package com.wolverine.solutions.accountservice.enums.controller;

import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "BusinessProfile API")
public interface BusinessProfileController {
    @ApiOperation("Add new data")
    BusinessProfileDTO save(@RequestBody BusinessProfileDTO businessProfile);

    @ApiOperation("Find by Id")
    BusinessProfileDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    List<BusinessProfileDTO> list();

    @ApiOperation("Pagination request")
    Page<BusinessProfileDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    BusinessProfileDTO update(@RequestBody BusinessProfileDTO dto, @PathVariable("id") String id);

    @PatchMapping("/{id}")
    void restore(@PathVariable("id") String id);
}