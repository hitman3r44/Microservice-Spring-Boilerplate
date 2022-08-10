package com.wolverine.solutions.billingservice.service;

import com.wolverine.solutions.billingservice.enums.dto.AddressDTO;
import com.wolverine.solutions.billingservice.enums.entity.AddressDao;
import com.wolverine.solutions.billingservice.enums.request.CreateAddressRequest;
import com.wolverine.solutions.billingservice.enums.request.UpdateAddressRequest;
import com.wolverine.solutions.billingservice.enums.response.GetAddressResponse;
import java.util.List;
import java.util.Optional;

public interface AddressService {

  public AddressDao createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);

  public Optional<AddressDao> findById(String addressId);

  public AddressDTO convertToDto(AddressDao addressDao);
  public AddressDao convertToEntity(AddressDTO addressDTO);
  public AddressDao convertToEntity(CreateAddressRequest createAddressRequest);
}
