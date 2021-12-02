package com.wolverine.solutions.paymentservice;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.wolverine.solutions"})
@EnableFeignClients(basePackages = {"com.wolverine.solutions"})
@EnableDiscoveryClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
		Stripe.apiKey = "sk_test_51HyGx6G9R9y827ntfKTizO243LzKHnaNIucO8i7apU0zuTIE5iNAes6l64aoWczGwiCnnBNsvvrgS95nfpbWa2cw00FnScmrhd";
	}

}

