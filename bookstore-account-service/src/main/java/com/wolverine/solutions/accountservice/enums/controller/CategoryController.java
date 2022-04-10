package com.wolverine.solutions.accountservice.enums.controller;

import com.wolverine.solutions.accountservice.enums.dto.CategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "Category API")
public interface CategoryController {
    @ApiOperation("Add new data")
    CategoryDTO save(@RequestBody CategoryDTO category);

    @ApiOperation("Find by Id")
    CategoryDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    List<CategoryDTO> list();

    @ApiOperation("Pagination request")
    Page<CategoryDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    CategoryDTO update(@RequestBody CategoryDTO dto, @PathVariable("id") String id);
}