package com.aqua.prod.dao;

import com.aqua.prod.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserDAO extends ListCrudRepository<User, Long> {
    Optional<User> findByUserNameIgnoreCase(String userName);


    Optional<User> findByEmailIgnoreCase(String email);
}