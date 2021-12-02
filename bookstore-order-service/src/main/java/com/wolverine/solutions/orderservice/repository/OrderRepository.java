package com.wolverine.solutions.orderservice.repository;

import com.wolverine.solutions.orderservice.repository.dao.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order, String> {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(String userId);
}
