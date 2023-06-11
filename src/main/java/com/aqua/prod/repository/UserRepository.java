package com.aqua.prod.repository;

import com.aqua.prod.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}