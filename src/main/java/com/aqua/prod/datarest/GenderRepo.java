package com.aqua.prod.datarest;

import com.aqua.prod.entity.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepo extends CrudRepository<Gender, Long> {
}