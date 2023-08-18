package com.aqua.prod.datarest;

import com.aqua.prod.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepo extends JpaRepository<Status, Integer> {
    Optional<Status> getStatusByName(String name);
}
