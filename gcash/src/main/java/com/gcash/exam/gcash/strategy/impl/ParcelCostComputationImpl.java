package com.gcash.exam.gcash.strategy.impl;

import com.gcash.exam.gcash.common.MyntPriceProperties;
import com.gcash.exam.gcash.dto.ParcelCost;
import com.gcash.exam.gcash.strategy.ParcelCostComputation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelCostComputationImpl implements ParcelCostComputation {
    private final MyntPriceProperties myntPriceProperties;

    @Override
    public ParcelCost reject(double weight) {
        double price = Double.parseDouble(myntPriceProperties.getReject());
        return new ParcelCost("1", "Reject", price);
    }

    @Override
    public ParcelCost heavy(double weight) {
        double cost = Double.parseDouble(myntPriceProperties.getHeavy()) * weight;
        return new ParcelCost("2", "Heavy Parcel", cost);
    }

    @Override
    public ParcelCost small(double volume) {
        double cost = Double.parseDouble(myntPriceProperties.getSmall()) * volume;
        return new ParcelCost("3", "Small Parcel", cost);
    }

    @Override
    public ParcelCost medium(double volume) {
        double cost = Double.parseDouble(myntPriceProperties.getMedium()) * volume;
        return new ParcelCost("4", "Medium Parcel", cost);
    }

    @Override
    public ParcelCost large(double volume) {
        double cost = Double.parseDouble(myntPriceProperties.getLarge()) * volume;
        return new ParcelCost("5", "Large Parcel", cost);
    }
}
