package com.ahuiali.weight_record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeightRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightRecordApplication.class, args);
    }

}
