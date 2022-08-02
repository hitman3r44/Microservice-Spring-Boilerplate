package com.wolverine.solutions.billingservice.service;

import com.wolverine.solutions.billingservice.enums.request.CreateAddressRequest;
import com.wolverine.solutions.billingservice.enums.request.UpdateAddressRequest;
import com.wolverine.solutions.billingservice.enums.response.GetAddressResponse;
import java.util.List;

public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
