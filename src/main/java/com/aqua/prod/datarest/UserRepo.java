package com.aqua.prod.datarest;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends GenericRepo<User, Long> {
    Optional<User> findByUserNameIgnoreCase(String userName);

    Optional<User> findByEmailIgnoreCase(String email);
}