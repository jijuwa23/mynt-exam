package com.gcash.exam.gcash.dto;

import lombok.Data;

@Data
public class VoucherResponse {
    private String code;
    private float discount;
    private String expiry;
}
