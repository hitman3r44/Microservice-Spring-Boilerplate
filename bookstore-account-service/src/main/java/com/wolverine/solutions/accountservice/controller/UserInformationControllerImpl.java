package com.wolverine.solutions.accountservice.controller;

import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import com.wolverine.solutions.accountservice.service.UserInformationService;
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

/**
 * @author Sumit Sarkar
 */
@RequestMapping("user-information")
@RestController
class UserInformationControllerImpl implements UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserInformationDTO save(@RequestBody UserInformationDTO userInformationDTO) {
        UserInformation userInformation = userInformationService.convertToEntity(userInformationDTO);
        return userInformationService.convertToDto(userInformationService.save(userInformation));
    }

    @Override
    @GetMapping("/{id}")
    public UserInformationDTO findById(@PathVariable("id") String id) {
        UserInformation userInformation = userInformationService.findById(id).orElse(null);
        return userInformationService.convertToDto(userInformation);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userInformationService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<UserInformationDTO> list() {
        List<UserInformation> userInformationDTOList = userInformationService.findAll();
        return userInformationDTOList
                .stream()
                .map(userInformationService::convertToDto).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<UserInformationDTO> pageQuery(Pageable pageable) {
        Page<UserInformation> userInformationPage = userInformationService.findAll(pageable);
        List<UserInformationDTO> dtoList = userInformationPage
                .stream()
                .map(userInformationService::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, userInformationPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public UserInformationDTO update(@RequestBody UserInformationDTO userInformationDTO, @PathVariable("id") String id) {
        UserInformation userInformation = userInformationService.convertToEntity(userInformationDTO);
        return userInformationService.convertToDto(userInformationService.update(userInformation, id));
    }
}
