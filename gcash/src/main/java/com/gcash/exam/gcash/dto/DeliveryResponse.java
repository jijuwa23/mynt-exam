package com.gcash.exam.gcash.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryResponse {
    private String parcelType;
    private double weight;
    private double volume;
    private String voucherCode;
    private BigDecimal discount;
    private BigDecimal deliveryFee;
}
