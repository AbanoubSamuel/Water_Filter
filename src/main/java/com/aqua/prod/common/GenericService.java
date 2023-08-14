package com.aqua.prod.common;

import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, D> {
    List<T> getAll();

    T getById(int id);

    T save(D entity);

    void delete(int id);

//    Optional<T> checkEntityByName(String name);

    T update(int statusId, D dto);
}
