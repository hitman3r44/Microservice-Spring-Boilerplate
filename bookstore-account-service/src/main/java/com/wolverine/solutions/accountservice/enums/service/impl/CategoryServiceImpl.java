package com.wolverine.solutions.accountservice.enums.service.impl;

import com.wolverine.solutions.accountservice.enums.dao.CategoryRepository;
import com.wolverine.solutions.accountservice.enums.dto.CategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.Category;
import com.wolverine.solutions.accountservice.enums.service.CategoryService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category entity) {
        return repository.save(entity);
    }

    @Override
    public List<Category> save(List<Category> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        Page<Category> entityPage = repository.findAll(pageable);
        List<Category> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Category update(Category entity, String id) {
        Optional<Category> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public Category asEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    @Override
    public CategoryDTO asDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}