package com.gcash.exam.gcash.services.impl;

import ch.qos.logback.core.util.StringUtil;
import com.gcash.exam.gcash.dto.DeliveryResponse;
import com.gcash.exam.gcash.dto.Parcel;
import com.gcash.exam.gcash.dto.ParcelCost;
import com.gcash.exam.gcash.dto.VoucherResponse;
import com.gcash.exam.gcash.exception.MyntException;
import com.gcash.exam.gcash.services.DeliveryService;
import com.gcash.exam.gcash.services.client.MyntFeignClient;
import com.gcash.exam.gcash.strategy.CostCalculator;
import com.gcash.exam.gcash.strategy.DeliveryFeeCalculator;
import com.gcash.exam.gcash.strategy.VolumeCalculator;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final CostCalculator costCalculator;
    private final VolumeCalculator volumeCalculator;
    private final DeliveryFeeCalculator deliveryFeeCalculator;
    private final MyntFeignClient feignClient;

    @Override
    public DeliveryResponse deliveryFee(Parcel parcel) {
        //Compute Volume
        double volume = volumeCalculator.computeVolume(parcel);
        //Compute Cost
        ParcelCost parcelCost = costCalculator.calculateCost(parcel.getWeight(), volume);

        //Check Voucher
        if (isVoucherCodeAbsent(parcel))
            return buildResponse(parcelCost, parcel, volume, 0, 0);

        //Call Voucher WS
        VoucherResponse voucherResponse = getVoucher(parcel.getVoucherCode().trim());

        //Compute Discount
        double discount = computeDiscount(voucherResponse, parcel);
        //Compute Delivery Fee
        double deliveryFee = deliveryFeeCalculator
                .deliveryFee(parcel, parcelCost.getCost(), discount);

        return buildResponse(parcelCost, parcel, volume, discount, deliveryFee);
    }

    private double computeDiscount(VoucherResponse voucherResponse, Parcel parcel) {
        return parcel.getWeight() > 50 ? 0 : voucherResponse.getDiscount();
    }

    private DeliveryResponse buildResponse(ParcelCost parcelCost, Parcel parcel, double volume, double discount
            , double deliveryFee) {
        return DeliveryResponse.builder()
                .deliveryFee(BigDecimal.valueOf(discount == 0 ? parcelCost.getCost() : deliveryFee).setScale(2))
                .discount(discount != 0 ? BigDecimal.valueOf(discount).setScale(2) : null)
                .parcelType(parcelCost.getRuleName())
                .voucherCode(parcel.getVoucherCode())
                .volume(volume)
                .weight(parcel.getWeight())
                .build();
    }

    private boolean isVoucherCodeAbsent(Parcel parcel) {
        return StringUtil.isNullOrEmpty(parcel.getVoucherCode());
    }

    private VoucherResponse getVoucher(String voucherCode) {
        try {
            return feignClient.getVoucher("apikey", voucherCode);
        } catch (FeignException e) {
            log.info("Voucher Response Status: {}, Message: {}", e.status(), e.getMessage());
            throw new MyntException(HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage());
        }
    }
}

