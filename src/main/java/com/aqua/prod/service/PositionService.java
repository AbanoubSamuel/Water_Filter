package com.aqua.prod.service;

import com.aqua.prod.entity.Position;

import java.util.Optional;

public interface PositionService {
    Optional<Position> checkPositionByName(String name);
}