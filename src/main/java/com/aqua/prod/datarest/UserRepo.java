package com.aqua.prod.datarest;

import com.aqua.prod.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserNameIgnoreCase(String userName);

    Optional<User> findByEmailIgnoreCase(String email);
}