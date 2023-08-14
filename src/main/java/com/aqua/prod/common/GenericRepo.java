package com.aqua.prod.common;

import com.aqua.prod.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface GenericRepo<T> extends JpaRepository<T, Integer> {
    Optional<T> getEntityByName(String name);

}
