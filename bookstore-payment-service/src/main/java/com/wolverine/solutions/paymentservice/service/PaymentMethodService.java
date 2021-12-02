package com.wolverine.solutions.paymentservice.service;

import com.wolverine.solutions.paymentservice.web.CreatePaymentMethodRequest;
import com.wolverine.solutions.paymentservice.web.GetPaymentMethodResponse;

import java.util.List;


public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
