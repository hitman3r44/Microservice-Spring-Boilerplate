package com.wolverine.solutions.accountservice.enums.controller;

import com.wolverine.solutions.accountservice.enums.dto.ParentCategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "ParentCategory API")
public interface ParentCategoryController {
    @ApiOperation("Add new data")
    ParentCategoryDTO save(@RequestBody ParentCategoryDTO parentCategory);

    @ApiOperation("Find by Id")
    ParentCategoryDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    List<ParentCategoryDTO> list();

    @ApiOperation("Pagination request")
    Page<ParentCategoryDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    ParentCategoryDTO update(@RequestBody ParentCategoryDTO dto, @PathVariable("id") String id);
}