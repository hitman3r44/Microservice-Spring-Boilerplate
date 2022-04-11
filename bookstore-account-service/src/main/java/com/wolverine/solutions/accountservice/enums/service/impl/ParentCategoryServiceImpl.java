package com.wolverine.solutions.accountservice.enums.service.impl;

import com.wolverine.solutions.accountservice.enums.dao.ParentCategoryRepository;
import com.wolverine.solutions.accountservice.enums.dto.ParentCategoryDTO;
import com.wolverine.solutions.accountservice.enums.entity.ParentCategory;
import com.wolverine.solutions.accountservice.enums.service.ParentCategoryService;
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
public class ParentCategoryServiceImpl implements ParentCategoryService {
    private final ParentCategoryRepository repository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    public ParentCategoryServiceImpl(ParentCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParentCategory save(ParentCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<ParentCategory> save(List<ParentCategory> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ParentCategory> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ParentCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<ParentCategory> findAll(Pageable pageable) {
        Page<ParentCategory> entityPage = repository.findAll(pageable);
        List<ParentCategory> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public ParentCategory update(ParentCategory entity, String id) {
        Optional<ParentCategory> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public ParentCategory asEntity(ParentCategoryDTO parentCategoryDTO) {
        return modelMapper.map(parentCategoryDTO, ParentCategory.class);
    }

    @Override
    public ParentCategoryDTO asDTO(ParentCategory save) {
        return modelMapper.map(save, ParentCategoryDTO.class);
    }
}