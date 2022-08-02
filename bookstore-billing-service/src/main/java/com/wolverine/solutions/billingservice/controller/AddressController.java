package com.wolverine.solutions.billingservice.controller;

import com.wolverine.solutions.billingservice.enums.request.CreateAddressRequest;
import com.wolverine.solutions.billingservice.enums.request.UpdateAddressRequest;
import com.wolverine.solutions.billingservice.enums.response.GetAddressResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Sumit Sarkar
 */
public interface AddressController {
    @PostMapping("/address")
    ResponseEntity<Object> createAddress(@RequestBody CreateAddressRequest createAddressRequest);

    @PutMapping("/address")
    ResponseEntity<Object> updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest);

    @GetMapping("/address")
    ResponseEntity<List<GetAddressResponse>> getAddress();

    @GetMapping("/address/{addressId}")
    ResponseEntity<GetAddressResponse> getAddressById(@PathVariable("addressId") String addressId);

    @DeleteMapping("/address/{addressId}")
    ResponseEntity<?> deleteAddressById(@PathVariable("addressId") String addressId);
}
