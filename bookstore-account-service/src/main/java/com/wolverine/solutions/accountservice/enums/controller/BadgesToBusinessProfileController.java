package com.wolverine.solutions.accountservice.enums.controller;

import com.wolverine.solutions.accountservice.enums.dto.BadgesToBusinessProfileDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@ApiModel
@Api(tags = "BadgesToBusinessProfile API")
public interface BadgesToBusinessProfileController {
    @ApiOperation("Add new data")
    BadgesToBusinessProfileDTO save(@RequestBody BadgesToBusinessProfileDTO badgesToBusinessProfile);

    @ApiOperation("Find by Id")
    BadgesToBusinessProfileDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    List<BadgesToBusinessProfileDTO> list();

    @ApiOperation("Pagination request")
    Page<BadgesToBusinessProfileDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    BadgesToBusinessProfileDTO update(@RequestBody BadgesToBusinessProfileDTO dto, @PathVariable("id") String id);
}