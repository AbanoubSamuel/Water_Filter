package com.aqua.prod.common;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.common.Mapper;
import com.aqua.prod.common.GenericService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenericServiceImpl<T, D> implements GenericService<T, D> {
    private final GenericRepo<T,Integer> repository;
    private final Mapper<T, D> mapper;

    public GenericServiceImpl(GenericRepo<T,Integer> repository, Mapper<T, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(D dto) {
        return repository.save(mapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

//    @Override
//    public Optional<T> checkEntityByName(String name) {
//        return repository.findBy();
//    }

    @Override
    public T update(int statusId, D dto) {
        T t = repository.findById(statusId)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));

        return repository.save(mapper.fromDtoToEntity(dto));
    }
}
