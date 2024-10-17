package com.gcash.exam.gcash.strategy;

import com.gcash.exam.gcash.dto.ParcelCost;

public interface CostCalculator {
    ParcelCost calculateCost(double weight, double volume);
}
