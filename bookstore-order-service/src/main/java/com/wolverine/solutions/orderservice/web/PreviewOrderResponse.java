package com.wolverine.solutions.orderservice.web;

import com.wolverine.solutions.commons.web.GetAddressResponse;
import com.wolverine.solutions.orderservice.repository.dao.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviewOrderResponse {
    private List<OrderItem> orderItems = new ArrayList<>();
    private GetAddressResponse shippingAddress;
    private GetAddressResponse billingAddress;
    private Card card;
    private Double itemsTotalPrice;
    private Double taxPrice;
    private Double shippingPrice;
    private Double totalPrice;
}
