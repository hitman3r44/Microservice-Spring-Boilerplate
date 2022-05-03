package com.wolverine.solutions.accountservice.enums.service.impl;

import com.wolverine.solutions.accountservice.enums.dao.BusinessProfileRepository;
import com.wolverine.solutions.accountservice.enums.dto.BusinessProfileDTO;
import com.wolverine.solutions.accountservice.enums.entity.BusinessProfile;
import com.wolverine.solutions.accountservice.enums.service.BusinessProfileService;
import com.wolverine.solutions.commons.exception.RunTimeExceptionPlaceHolder;
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
public class BusinessProfileServiceImpl implements BusinessProfileService {
    @Autowired
    BusinessProfileRepository repository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public BusinessProfile save(BusinessProfile entity) {
        return repository.save(entity);
    }

    @Override
    public List<BusinessProfile> save(List<BusinessProfile> entities) {
        return (List<BusinessProfile>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<BusinessProfile> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<BusinessProfile> findAll() {
        return (List<BusinessProfile>) repository.findAll();
    }

    @Override
    public Page<BusinessProfile> findAll(Pageable pageable) {
        Page<BusinessProfile> entityPage = repository.findAll(pageable);
        List<BusinessProfile> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public BusinessProfile update(BusinessProfile entity, String id) {
        Optional<BusinessProfile> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public BusinessProfile asEntity(BusinessProfileDTO businessProfileDTO) {
        return modelMapper.map(businessProfileDTO, BusinessProfile.class);
    }

    @Override
    public BusinessProfileDTO asDTO(BusinessProfile businessProfile) {
        return modelMapper.map(businessProfile, BusinessProfileDTO.class);
    }

    @Override
    public void restoreById(String id) {
        Optional<BusinessProfile> businessProfileOptional = repository.findById(id);

        BusinessProfile businessProfile = businessProfileOptional.orElseThrow(() -> new RunTimeExceptionPlaceHolder("Business profile doesn't exist!!"));

        if (Boolean.FALSE.equals(businessProfile.getIsDeleted()))
            throw new RunTimeExceptionPlaceHolder("Business profile is not deleted!!");

        businessProfile.setIsDeleted(false);
        repository.save(businessProfile);
    }
}