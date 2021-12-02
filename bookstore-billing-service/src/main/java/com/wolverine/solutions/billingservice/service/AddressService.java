package com.wolverine.solutions.billingservice.service;

import com.wolverine.solutions.billingservice.web.CreateAddressRequest;
import com.wolverine.solutions.billingservice.web.GetAddressResponse;
import com.wolverine.solutions.billingservice.web.UpdateAddressRequest;

import java.util.List;

public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
