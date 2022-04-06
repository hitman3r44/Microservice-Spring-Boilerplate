package com.wolverine.solutions.accountservice.controller;

import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.List;

@Api(tags = "UserInformation API")
public interface UserInformationController {
    @ApiOperation("Add new data")
    UserInformationDTO save(@RequestBody UserInformationDTO userInformation) throws ParseException;

    @ApiOperation("Find by Id")
    UserInformationDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    List<UserInformationDTO> list();

    @ApiOperation("Pagination request")
    Page<UserInformationDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    UserInformationDTO update(@RequestBody UserInformationDTO dto, @PathVariable("id") String id);

    @PatchMapping("/{id}")
    void restore(@PathVariable("id") String id);
}