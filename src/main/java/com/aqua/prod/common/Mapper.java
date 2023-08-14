package com.aqua.prod.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface Mapper<T, D> {
    T fromDtoToEntity(D dto);

    D fromEntityToDto(T entity);
}
