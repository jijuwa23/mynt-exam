package com.gcash.exam.gcash.strategy.impl;

import ch.qos.logback.core.util.StringUtil;
import com.gcash.exam.gcash.dto.Parcel;
import com.gcash.exam.gcash.strategy.DeliveryFeeCalculator;
import org.springframework.stereotype.Service;

@Service
public class DeliveryFeeCalculatorImpl implements DeliveryFeeCalculator {
    public double deliveryFee(Parcel parcel, double cost, double voucherAmount) {
        return StringUtil.isNullOrEmpty(parcel.getVoucherCode()) ? cost : cost - voucherAmount;
    }
}
