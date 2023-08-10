package com.aqua.prod.datarest;

import com.aqua.prod.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepo extends JpaRepository<Position, Integer> {
}