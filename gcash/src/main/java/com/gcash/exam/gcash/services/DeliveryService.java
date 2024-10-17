package com.gcash.exam.gcash.services;

import com.gcash.exam.gcash.dto.DeliveryResponse;
import com.gcash.exam.gcash.dto.Parcel;

public interface DeliveryService {
    DeliveryResponse deliveryFee(Parcel parcel);
}
