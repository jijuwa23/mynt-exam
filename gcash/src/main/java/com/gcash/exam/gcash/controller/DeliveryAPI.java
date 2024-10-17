package com.gcash.exam.gcash.controller;

import com.gcash.exam.gcash.dto.DeliveryResponse;
import com.gcash.exam.gcash.dto.Parcel;
import org.springframework.http.ResponseEntity;

public interface DeliveryAPI {

    public ResponseEntity<DeliveryResponse> deliveryFee(Parcel parcel);
}

