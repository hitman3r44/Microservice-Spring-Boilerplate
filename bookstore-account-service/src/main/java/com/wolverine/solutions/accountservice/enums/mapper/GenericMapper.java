package com.wolverine.solutions.accountservice.enums.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenericMapper<E, D> {
    E asEntity(D dto);

    D asDTO(E entity);

    List<E> asEntityList(List<D> dtoList);

    List<D> asDTOList(List<E> entityList);

}