package com.gcash.exam.gcash.controller;

import com.gcash.exam.gcash.dto.DeliveryResponse;
import com.gcash.exam.gcash.dto.Parcel;
import com.gcash.exam.gcash.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mynt/delivery/")
public class DeliveryController implements DeliveryAPI {

    private final DeliveryService deliveryService;

    @Override
    @PostMapping("/fee")
    public ResponseEntity<DeliveryResponse> deliveryFee(@RequestBody Parcel parcel) {
        return ResponseEntity.ok(deliveryService.deliveryFee(parcel));
    }
}
