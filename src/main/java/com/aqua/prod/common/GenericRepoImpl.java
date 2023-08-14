package com.aqua.prod.common;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class GenericRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements GenericRepo<T,ID> {
    private EntityManager entityManager;

    public GenericRepoImpl(JpaEntityInformation<T, ?>
                                   entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T handleCustom(String id) {
        return null;
    }
}
