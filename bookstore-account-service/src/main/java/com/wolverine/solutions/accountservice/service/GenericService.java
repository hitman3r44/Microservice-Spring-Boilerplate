package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.entity.UserInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GenericService<E, M> {
    E save(E entity);

    List<E> save(List<E> entities);

    void deleteById(M id);

    void restoreById(String id);

    Optional<E> findById(M id);

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    E update(UserInformation entity, String id);
}