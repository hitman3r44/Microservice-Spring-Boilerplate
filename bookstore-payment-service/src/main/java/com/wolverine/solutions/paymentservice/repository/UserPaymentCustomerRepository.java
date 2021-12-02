package com.wolverine.solutions.paymentservice.repository;

import com.wolverine.solutions.paymentservice.repository.dao.UserPaymentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPaymentCustomerRepository extends JpaRepository<UserPaymentCustomer, String> {

    UserPaymentCustomer findByUserId(String userId);
}
