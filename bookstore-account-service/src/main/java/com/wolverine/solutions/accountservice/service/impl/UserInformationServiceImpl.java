package com.wolverine.solutions.accountservice.service.impl;

import com.wolverine.solutions.accountservice.enums.dto.UserInformationDTO;
import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import com.wolverine.solutions.accountservice.repository.UserInformationRepository;
import com.wolverine.solutions.accountservice.service.UserInformationService;
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
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserInformationRepository repository;

    @Override
    public UserInformation save(UserInformation entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserInformation> save(List<UserInformation> entities) {
        return (List<UserInformation>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void restoreById(String id) {
        Optional<UserInformation> existingUserInformation = repository.findById(id);

        UserInformation userInformation = existingUserInformation.orElseThrow(() -> new RunTimeExceptionPlaceHolder("userInformationId doesn't exist!!"));

        if (Boolean.FALSE.equals(userInformation.getIsDeleted()))
            throw new RunTimeExceptionPlaceHolder("UserInformation is not deleted!!");

        userInformation.setIsDeleted(false);
        repository.save(userInformation);
    }

    @Override
    public Optional<UserInformation> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<UserInformation> findAll() {
        return (List<UserInformation>) repository.findAll();
    }

    @Override
    public Page<UserInformation> findAll(Pageable pageable) {
        Page<UserInformation> entityPage = repository.findAll(pageable);
        List<UserInformation> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public UserInformation update(UserInformation entity, String id) {
        Optional<UserInformation> optional = findById(id);
        if (optional.isPresent()) {
            entity.setCreatedAt(optional.get().getCreatedAt());
            entity.setIsDeleted(optional.get().getIsDeleted());
            return save(entity);
        }
        return null;
    }

    @Override
    public UserInformation findUserInformationByProfilePicture(String profilePicture) {
        return repository.findUserInformationByProfilePicture(profilePicture);
    }

    public UserInformationDTO convertToDto(UserInformation userInformation) {
        return modelMapper.map(userInformation, UserInformationDTO.class);
    }

    public UserInformation convertToEntity(UserInformationDTO userInformationDTO) {
        return modelMapper.map(userInformationDTO, UserInformation.class);
    }
}