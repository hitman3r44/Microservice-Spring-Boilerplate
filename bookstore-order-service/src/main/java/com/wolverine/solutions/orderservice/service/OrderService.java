package com.wolverine.solutions.orderservice.service;

import com.wolverine.solutions.orderservice.web.CreateOrderRequest;
import com.wolverine.solutions.orderservice.web.CreateOrderResponse;
import com.wolverine.solutions.orderservice.web.PreviewOrderRequest;
import com.wolverine.solutions.orderservice.web.PreviewOrderResponse;

import java.util.List;


public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest);

    CreateOrderResponse getOrderById(String orderId);

    List<CreateOrderResponse> getMyOrders();

    List<CreateOrderResponse> getAllOrders();
}
