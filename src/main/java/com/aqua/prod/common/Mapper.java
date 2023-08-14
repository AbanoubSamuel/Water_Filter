package com.aqua.prod.common;

public interface Mapper<T, D> {
    T fromDtoToEntity(D dto);

    D fromEntityToDto(T entity);
}
