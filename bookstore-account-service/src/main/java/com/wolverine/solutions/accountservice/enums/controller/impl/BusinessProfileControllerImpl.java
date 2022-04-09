package com.wolverine.solutions.accountservice.enums.controller.impl;

import com.wolverine.solutions.accountservice.enums.controller.BusinessProfileController;
import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.enums.service.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("business-profile")
@RestController
public class BusinessProfileControllerImpl implements BusinessProfileController {

    @Autowired
    private BusinessProfileService businessProfileService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessProfileDTO save(@RequestBody BusinessProfileDTO businessProfileDTO) {
        BusinessProfile businessProfile = businessProfileService.asEntity(businessProfileDTO);
        return businessProfileService.asDTO(businessProfileService.save(businessProfile));
    }

    @Override
    @GetMapping("/{id}")
    public BusinessProfileDTO findById(@PathVariable("id") String id) {
        BusinessProfile businessProfile = businessProfileService.findById(id).orElse(null);
        return businessProfileService.asDTO(businessProfile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        businessProfileService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<BusinessProfileDTO> list() {
        List<BusinessProfile> businessProfileList = businessProfileService.findAll();
        return businessProfileList.stream().map(businessProfileService::asDTO).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<BusinessProfileDTO> pageQuery(Pageable pageable) {
        Page<BusinessProfile> businessProfilePage = businessProfileService.findAll(pageable);
        List<BusinessProfileDTO> dtoList = businessProfilePage
                .stream()
                .map(businessProfileService::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, businessProfilePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public BusinessProfileDTO update(@RequestBody BusinessProfileDTO businessProfileDTO, @PathVariable("id") String id) {
        BusinessProfile businessProfile = businessProfileService.asEntity(businessProfileDTO);
        return businessProfileService.asDTO(businessProfileService.update(businessProfile, id));
    }

    @Override
    @PatchMapping("/{id}")
    public void restore(@PathVariable("id") String id) {
        businessProfileService.restoreById(id);
    }
}