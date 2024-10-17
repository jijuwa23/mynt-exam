package com.gcash.exam.gcash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelCost {
    private String priority;
    private String ruleName;
    private double cost;
}
