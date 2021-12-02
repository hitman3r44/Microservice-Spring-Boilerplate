package com.wolverine.solutions.commons.feign;

import com.wolverine.solutions.commons.web.CreatePaymentRequest;
import com.wolverine.solutions.commons.web.CreatePaymentResponse;
import com.wolverine.solutions.commons.web.GetPaymentMethodResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("bookstore-payment-service")
public interface PaymentFeignClient {

    @GetMapping("/paymentMethod/{paymentMethodId}")
    GetPaymentMethodResponse getMyPaymentMethodById(@PathVariable("paymentMethodId") String paymentMethodId);

    @PostMapping("/pay")
    CreatePaymentResponse doPayment(CreatePaymentRequest createPaymentRequest);
}
