package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.PositionRepo;
import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.PositionDto;
import com.aqua.prod.entity.Position;
import com.aqua.prod.service.PositionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionRepo positionRepo;
    private StatusRepo statusRepo;

    public PositionServiceImpl(PositionRepo positionRepo, StatusRepo statusRepo)
    {
        this.positionRepo = positionRepo;
        this.statusRepo = statusRepo;
    }

    @Override
    public Position createPosition(PositionDto positionDto) throws EntityNotFoundException
    {
        Position position = new Position();
        position.setName(positionDto.getName());
        position.setStatus(statusRepo.findById(positionDto.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found")));
        position.setDescription(positionDto.getDescription());
        return positionRepo.save(position);
    }

    @Override
    public Optional<Position> checkPositionByName(String name)
    {
        return positionRepo.findByNameIgnoreCase(name);
    }

    @Override
    public Optional<Position> getPositionById(PositionDto positionDto)
    {
        Optional<Position> position = positionRepo.findById(positionDto.getId());
        if (position.isPresent()) {
            return position;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
