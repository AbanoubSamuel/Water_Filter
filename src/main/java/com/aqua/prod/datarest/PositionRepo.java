package com.aqua.prod.datarest;

import com.aqua.prod.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepo extends JpaRepository<Position, Integer> {
    Optional<Position> findByNameIgnoreCase(String name);
}