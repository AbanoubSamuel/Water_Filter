package com.aqua.prod.service;

import com.aqua.prod.dto.CreatePositionDto;
import com.aqua.prod.entity.Position;

public interface PositionService {

    Position createPosition(CreatePositionDto createPositionDto);
}
