package com.wolverine.solutions.billingservice.config;

import feign.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BillingServiceConfig {
    
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
