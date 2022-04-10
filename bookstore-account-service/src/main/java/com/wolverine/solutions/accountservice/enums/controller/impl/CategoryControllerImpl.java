package com.wolverine.solutions.accountservice.enums.controller.impl;

import com.wolverine.solutions.accountservice.enums.controller.CategoryController;
import com.wolverine.solutions.accountservice.enums.dto.CategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.Category;
import com.wolverine.solutions.accountservice.enums.service.CategoryService;
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

@RequestMapping("/category")
@RestController
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.asEntity(categoryDTO);
        return categoryService.asDTO(categoryService.save(category));
    }

    @Override
    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") String id) {
        Category category = categoryService.findById(id).orElse(null);
        return categoryService.asDTO(category);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        categoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CategoryDTO> list() {
        List<Category> categoryList = categoryService.findAll();
        return categoryList.stream().map(categoryService::asDTO).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CategoryDTO> pageQuery(Pageable pageable) {
        Page<Category> categoryPage = categoryService.findAll(pageable);
        List<CategoryDTO> dtoList = categoryPage
                .stream()
                .map(categoryService::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, categoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") String id) {
        Category category = categoryService.asEntity(categoryDTO);
        return categoryService.asDTO(categoryService.update(category, id));
    }
}