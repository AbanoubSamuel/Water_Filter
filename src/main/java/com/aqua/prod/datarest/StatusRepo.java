package com.aqua.prod.datarest;

import com.aqua.prod.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StatusRepo extends CrudRepository<Status, Long> {
    Optional<Status> getStatusByName(String name);
}
