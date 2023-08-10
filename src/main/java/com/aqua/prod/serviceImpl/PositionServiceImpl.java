package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.PositionRepo;
import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.CreatePositionDto;
import com.aqua.prod.entity.Position;
import com.aqua.prod.service.PositionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionRepo positionRepo;
    private StatusRepo statusRepo;

    public PositionServiceImpl(PositionRepo positionRepo, StatusRepo statusRepo)
    {
        this.positionRepo = positionRepo;
        this.statusRepo = statusRepo;
    }

    public Position createPosition(CreatePositionDto createPositionDto)
    {
        Position position = new Position();
        position.setName(createPositionDto.getName());
        position.setStatus(statusRepo.findById(createPositionDto.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found")));
        position.setDescription(createPositionDto.getDescription());
        return positionRepo.save(position);
    }
}
