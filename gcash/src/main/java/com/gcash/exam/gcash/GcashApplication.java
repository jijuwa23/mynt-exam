package com.gcash.exam.gcash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GcashApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcashApplication.class, args);
    }

}
