package com.wolverine.solutions.billingservice.repository;

import com.wolverine.solutions.billingservice.repository.dao.AddressDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AddressRepository extends CrudRepository<AddressDao, String> {

    Optional<List<AddressDao>> findByUserId(String userId);

    Optional<AddressDao> findByAddressId(String addressId);

    Boolean existsByUserId(String userId);
    
}
