package com.gcash.exam.gcash.strategy.impl;

import com.gcash.exam.gcash.dto.ParcelCost;
import com.gcash.exam.gcash.strategy.CostCalculator;
import com.gcash.exam.gcash.strategy.ParcelCostComputation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostCalculatorImpl implements CostCalculator {
    private final ParcelCostComputation parcelCostComputation;

    @Override
    public ParcelCost calculateCost(double weight, double volume) {

        if (weight > 50)
            return parcelCostComputation.reject(weight);
        if (weight > 10)
            return parcelCostComputation.heavy(weight);
        if (volume < 1500)
            return parcelCostComputation.small(volume);
        if (volume < 2500)
            return parcelCostComputation.medium(volume);

        return parcelCostComputation.large(volume);
    }

}
