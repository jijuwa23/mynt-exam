package com.gcash.exam.gcash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    private double weight;
    private double height;
    private double width;
    private double length;
    private String voucherCode;
}
