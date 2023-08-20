package com.aqua.prod.service;

import com.aqua.prod.dto.PositionDto;
import com.aqua.prod.entity.Position;

import java.util.Optional;

public interface PositionService {
    Position createPosition(PositionDto positionDto);

    Optional<Position> checkPositionByName(String name);

    Optional<Position> getPositionById(PositionDto positionDto);
}