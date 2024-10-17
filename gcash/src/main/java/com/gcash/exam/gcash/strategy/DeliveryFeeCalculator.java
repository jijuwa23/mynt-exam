package com.gcash.exam.gcash.strategy;

import com.gcash.exam.gcash.dto.Parcel;

public interface DeliveryFeeCalculator {
    double deliveryFee(Parcel parcel, double cost, double voucherAmount);
}
