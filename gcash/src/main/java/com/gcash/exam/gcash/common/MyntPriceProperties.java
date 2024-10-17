package com.gcash.exam.gcash.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "mynt.api.price")
public class MyntPriceProperties {
    private String reject;
    private String heavy;
    private String small;
    private String medium;
    private String large;

}
