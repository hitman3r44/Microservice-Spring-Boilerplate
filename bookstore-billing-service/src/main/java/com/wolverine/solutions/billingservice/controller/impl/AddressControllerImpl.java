package com.wolverine.solutions.billingservice.controller.impl;

import com.wolverine.solutions.billingservice.controller.AddressController;
import com.wolverine.solutions.billingservice.enums.dto.AddressDTO;
import com.wolverine.solutions.billingservice.enums.entity.AddressDao;
import com.wolverine.solutions.billingservice.enums.request.CreateAddressRequest;
import com.wolverine.solutions.billingservice.enums.request.UpdateAddressRequest;
import com.wolverine.solutions.billingservice.enums.response.GetAddressResponse;
import com.wolverine.solutions.billingservice.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("address")
@RestController
public class AddressControllerImpl implements AddressController {

    @Autowired
    AddressService addressService;

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        AddressDao addressDao = addressService.createAddress(createAddressRequest);
        return addressService.convertToDto(addressDao);
    }

    @Override
    @PutMapping()
    public ResponseEntity<Object> updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest) {
        addressService.updateAddress(updateAddressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<GetAddressResponse>> getAddress() {
        List<GetAddressResponse> address = addressService.getAddress();
        return ResponseEntity.ok(address);
    }

    @Override
    @GetMapping("{addressId}")
    public AddressDTO getAddressById(@PathVariable("addressId") String addressId) {
        AddressDao address = addressService.findById(addressId).orElse(null);
        return addressService.convertToDto(address);
    }

    @Override
    @DeleteMapping("{addressId}")
    public ResponseEntity<?> deleteAddressById(@PathVariable("addressId") String addressId) {
        addressService.deleteAddressById(addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
