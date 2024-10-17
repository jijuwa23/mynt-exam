package com.gcash.exam.gcash.strategy;

import com.gcash.exam.gcash.dto.ParcelCost;

public interface ParcelCostComputation {

    ParcelCost reject(double weight);

    ParcelCost heavy(double weight);

    ParcelCost small(double volume);

    ParcelCost medium(double volume);

    ParcelCost large(double volume);
}
