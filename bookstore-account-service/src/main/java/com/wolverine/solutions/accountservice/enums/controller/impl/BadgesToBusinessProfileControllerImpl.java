package com.wolverine.solutions.accountservice.enums.controller.impl;

import com.wolverine.solutions.accountservice.enums.controller.BadgesToBusinessProfileController;
import com.wolverine.solutions.accountservice.enums.dto.BadgesToBusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.service.BadgesToBusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/badges-to-business-profile")
@RestController
public class BadgesToBusinessProfileControllerImpl implements BadgesToBusinessProfileController {
    @Autowired
    BadgesToBusinessProfileService badgesToBusinessProfileService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BadgesToBusinessProfileDTO save(@RequestBody BadgesToBusinessProfileDTO badgesToBusinessProfileDTO) {
        BadgesToBusinessProfile badgesToBusinessProfile = badgesToBusinessProfileService.asEntity(badgesToBusinessProfileDTO);
        return badgesToBusinessProfileService.asDTO(badgesToBusinessProfileService.save(badgesToBusinessProfile));
    }

    @Override
    @GetMapping("/{id}")
    public BadgesToBusinessProfileDTO findById(@PathVariable("id") String id) {
        BadgesToBusinessProfile badgesToBusinessProfile = badgesToBusinessProfileService.findById(id).orElse(null);
        return badgesToBusinessProfileService.asDTO(badgesToBusinessProfile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        badgesToBusinessProfileService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<BadgesToBusinessProfileDTO> list() {
        return null;
    }

    @Override
    @GetMapping("/page-query")
    public Page<BadgesToBusinessProfileDTO> pageQuery(Pageable pageable) {
        Page<BadgesToBusinessProfile> badgesToBusinessProfilePage = badgesToBusinessProfileService.findAll(pageable);
        List<BadgesToBusinessProfileDTO> dtoList = badgesToBusinessProfilePage
                .stream()
                .map(badgesToBusinessProfileService::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, badgesToBusinessProfilePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public BadgesToBusinessProfileDTO update(@RequestBody BadgesToBusinessProfileDTO badgesToBusinessProfileDTO, @PathVariable("id") String id) {
        BadgesToBusinessProfile badgesToBusinessProfile = badgesToBusinessProfileService.asEntity(badgesToBusinessProfileDTO);
        return badgesToBusinessProfileService.asDTO(badgesToBusinessProfileService.update(badgesToBusinessProfile, id));
    }
}