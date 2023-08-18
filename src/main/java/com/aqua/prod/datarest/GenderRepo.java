package com.aqua.prod.datarest;

import com.aqua.prod.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Long> {
}