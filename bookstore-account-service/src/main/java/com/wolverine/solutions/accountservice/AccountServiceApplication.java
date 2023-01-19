package com.wolverine.solutions.accountservice;

import com.wolverine.solutions.accountservice.config.DevcontainerInitializer;
import com.wolverine.solutions.commons.security.GlobalResourceServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@SpringBootApplication
@ComponentScan(basePackages = {"com.wolverine.solutions", "com.wolverine.solutions.accountservice.enums.mapper"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GlobalResourceServerConfig.class)})

//@EnableJpaAuditing
@EnableFeignClients
@EnableDiscoveryClient
public class AccountServiceApplication {

    public static void main(String[] args) {
    if ("local".equals(System.getProperty("ENV"))) {
      DevcontainerInitializer.getProperties()
          .forEach((k, v) -> System.setProperty(k, String.valueOf(v)));
    }
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}