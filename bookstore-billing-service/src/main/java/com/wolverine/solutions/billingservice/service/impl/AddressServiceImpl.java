package com.wolverine.solutions.billingservice.service.impl;

import com.wolverine.solutions.billingservice.enums.dto.AddressDTO;
import com.wolverine.solutions.billingservice.enums.entity.AddressDao;
import com.wolverine.solutions.billingservice.enums.request.CreateAddressRequest;
import com.wolverine.solutions.billingservice.enums.request.UpdateAddressRequest;
import com.wolverine.solutions.billingservice.enums.response.GetAddressResponse;
import com.wolverine.solutions.billingservice.repository.AddressRepository;
import com.wolverine.solutions.billingservice.service.AddressService;
import com.wolverine.solutions.commons.util.CommonUtilityMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public AddressDao createAddress(CreateAddressRequest createAddressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        AddressDao addressDao = convertToEntity(createAddressRequest);
        addressDao.setUserId(userIdFromToken);

        addressRepository.save(addressDao);
        return addressDao;
    }


    @Override
    public List<GetAddressResponse> getAddress() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<List<AddressDao>> addresses = addressRepository
                .findByUserId(userIdFromToken);

        List<GetAddressResponse> responseList = new ArrayList<>();

        if (addresses.isPresent()) {
            addresses.get().forEach(address -> {
                responseList.add(GetAddressResponse.builder()
                        .addressId(address.getAddressId())
                        .addressLine1(address.getAddressLine1())
                        .addressLine2(address.getAddressLine2())
                        .city(address.getCity())
                        .country(address.getCountry())
                        .phone(address.getPhone())
                        .postalCode(address.getPostalCode())
                        .state(address.getState())
                        .userId(address.getUserId())
                        .build());
            });

            return responseList;
        }

        return new ArrayList<>();
    }

    @Override
    public void updateAddress(UpdateAddressRequest updateAddressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<AddressDao> addressFromDb = addressRepository.findByAddressId(updateAddressRequest.getAddressId());

        if (addressFromDb.isPresent()) {
            if (!userIdFromToken.equals(addressFromDb.get().getUserId())) {
                throw new RuntimeException("UnAuthorized!");
            }
        } else {
            throw new RuntimeException("Address doesn't exist!");
        }

        AddressDao addressDao = AddressDao.builder()
                .addressId(updateAddressRequest.getAddressId())
                .addressLine1(updateAddressRequest.getAddressLine1())
                .addressLine2(updateAddressRequest.getAddressLine2())
                .city(updateAddressRequest.getCity())
                .country(updateAddressRequest.getCountry())
                .phone(updateAddressRequest.getPhone())
                .postalCode(updateAddressRequest.getPostalCode())
                .state(updateAddressRequest.getState())
                .userId(userIdFromToken)
                .build();

        addressRepository.save(addressDao);
    }

    public Optional<AddressDao> findById(String addressId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<AddressDao> addressOptional = addressRepository.findByAddressId(addressId);
        if (addressOptional.isPresent()) {
            AddressDao address = addressOptional.get();

            if (!address.getUserId().equals(userIdFromToken)) {
                throw new RuntimeException("UnAuthorized");
            }
        }
        return addressOptional;
    }

    @Override
    public GetAddressResponse getAddressById(String addressId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<AddressDao> addressOptional = addressRepository.findByAddressId(addressId);

        if (addressOptional.isPresent()) {
            AddressDao address = addressOptional.get();

            if (!address.getUserId().equals(userIdFromToken)) {
                throw new RuntimeException("UnAuthorized");
            }

            return GetAddressResponse.builder()
                    .addressId(address.getAddressId())
                    .addressLine1(address.getAddressLine1())
                    .addressLine2(address.getAddressLine2())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .phone(address.getPhone())
                    .postalCode(address.getPostalCode())
                    .state(address.getState())
                    .userId(address.getUserId())
                    .build();
        }

        throw new RuntimeException("Address doesn't exist");
    }

    @Override
    public void deleteAddressById(String addressId) {
        getAddressById(addressId);
        addressRepository.deleteById(addressId);
    }

    public AddressDTO convertToDto(AddressDao addressDao) {
        return modelMapper.map(addressDao, AddressDTO.class);
    }

    public AddressDao convertToEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, AddressDao.class);
    }

    public AddressDao convertToEntity(CreateAddressRequest createAddressRequest) {
        return modelMapper.map(createAddressRequest, AddressDao.class);
    }
}

