package com.wolverine.solutions.billingservice.repository;

import com.wolverine.solutions.billingservice.enums.entity.AddressDao;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<AddressDao, String> {

    Optional<List<AddressDao>> findByUserId(String userId);

    Optional<AddressDao> findByAddressId(String addressId);

    Boolean existsByUserId(String userId);
    
}
