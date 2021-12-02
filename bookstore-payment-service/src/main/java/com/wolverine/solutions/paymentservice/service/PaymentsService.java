package com.wolverine.solutions.paymentservice.service;

import com.wolverine.solutions.paymentservice.web.CreatePaymentRequest;
import com.wolverine.solutions.paymentservice.web.CreatePaymentResponse;


public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
