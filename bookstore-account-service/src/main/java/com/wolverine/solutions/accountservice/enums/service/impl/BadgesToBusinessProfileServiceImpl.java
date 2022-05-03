package com.wolverine.solutions.accountservice.enums.service.impl;

import com.wolverine.solutions.accountservice.enums.dao.BadgesToBusinessProfileRepository;
import com.wolverine.solutions.accountservice.enums.dto.BadgesToBusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BadgesToBusinessProfile;
import com.wolverine.solutions.accountservice.enums.service.BadgesToBusinessProfileService;
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
public class BadgesToBusinessProfileServiceImpl implements BadgesToBusinessProfileService {

    @Autowired
    BadgesToBusinessProfileRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BadgesToBusinessProfile save(BadgesToBusinessProfile entity) {
        return repository.save(entity);
    }

    @Override
    public List<BadgesToBusinessProfile> save(List<BadgesToBusinessProfile> entities) {
        return (List<BadgesToBusinessProfile>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<BadgesToBusinessProfile> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<BadgesToBusinessProfile> findAll() {
        return (List<BadgesToBusinessProfile>) repository.findAll();
    }

    @Override
    public Page<BadgesToBusinessProfile> findAll(Pageable pageable) {
        Page<BadgesToBusinessProfile> entityPage = repository.findAll(pageable);
        List<BadgesToBusinessProfile> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public BadgesToBusinessProfile update(BadgesToBusinessProfile entity, String id) {
        Optional<BadgesToBusinessProfile> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public BadgesToBusinessProfile asEntity(BadgesToBusinessProfileDTO badgesToBusinessProfileDTO) {
        return modelMapper.map(badgesToBusinessProfileDTO, BadgesToBusinessProfile.class);
    }

    @Override
    public BadgesToBusinessProfileDTO asDTO(BadgesToBusinessProfile save) {
        return modelMapper.map(save, BadgesToBusinessProfileDTO.class);
    }
}