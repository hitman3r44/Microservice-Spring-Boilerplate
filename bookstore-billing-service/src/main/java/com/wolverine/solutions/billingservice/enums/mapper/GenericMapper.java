package com.wolverine.solutions.billingservice.enums.mapper;

import java.util.List;
import org.springframework.stereotype.Component;

public interface GenericMapper <E, D> {
    E asEntity(D dto);

    D asDTO(E entity);

    List<E> asEntityList(List<D> dtoList);

    List<D> asDTOList(List<E> entityList);
}