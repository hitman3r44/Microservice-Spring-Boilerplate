package com.wolverine.solutions.orderservice.repository;

import com.wolverine.solutions.orderservice.repository.dao.OrderShippingAddress;
import org.springframework.data.repository.CrudRepository;


public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, String> {
    OrderShippingAddress findByOrderId(String orderId);
}
