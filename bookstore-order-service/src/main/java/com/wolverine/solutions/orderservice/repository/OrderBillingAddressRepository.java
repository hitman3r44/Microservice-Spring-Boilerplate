package com.wolverine.solutions.orderservice.repository;

import com.wolverine.solutions.orderservice.repository.dao.OrderBillingAddress;
import org.springframework.data.repository.CrudRepository;


public interface OrderBillingAddressRepository extends CrudRepository<OrderBillingAddress, String> {
    OrderBillingAddress findByOrderId(String orderId);
}
