package com.aqua.prod.datarest;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.entity.Status;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StatusRepo extends GenericRepo<Status, Long> {
    Optional<Status> getStatusByName(String name);
}
