package com.wolverine.solutions.accountservice.enums.controller.impl;

import com.wolverine.solutions.accountservice.enums.controller.ParentCategoryController;
import com.wolverine.solutions.accountservice.enums.dto.ParentCategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;
import com.wolverine.solutions.accountservice.enums.service.ParentCategoryService;
import java.util.List;
import java.util.stream.Collectors;
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

@RequestMapping("/parent-category")
@RestController
public class ParentCategoryControllerImpl implements ParentCategoryController {

    @Autowired
    ParentCategoryService parentCategoryService;


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParentCategoryDTO save(@RequestBody ParentCategoryDTO parentCategoryDTO) {
        ParentCategory parentCategory = parentCategoryService.asEntity(parentCategoryDTO);
        return parentCategoryService.asDTO(parentCategoryService.save(parentCategory));
    }

    @Override
    @GetMapping("/{id}")
    public ParentCategoryDTO findById(@PathVariable("id") String id) {
        ParentCategory parentCategory = parentCategoryService.findById(id).orElse(null);
        return parentCategoryService.asDTO(parentCategory);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        parentCategoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ParentCategoryDTO> list() {
        List<ParentCategory> parentCategoryList = parentCategoryService.findAll();
        return parentCategoryList.stream().map(parentCategoryService::asDTO).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ParentCategoryDTO> pageQuery(Pageable pageable) {
        Page<ParentCategory> parentCategoryPage = parentCategoryService.findAll(pageable);
        List<ParentCategoryDTO> dtoList = parentCategoryPage
                .stream()
                .map(parentCategoryService::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, parentCategoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ParentCategoryDTO update(@RequestBody ParentCategoryDTO parentCategoryDTO, @PathVariable("id") String id) {
        ParentCategory parentCategory = parentCategoryService.asEntity(parentCategoryDTO);
        return parentCategoryService.asDTO(parentCategoryService.update(parentCategory, id));
    }
}