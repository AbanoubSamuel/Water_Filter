package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.PositionRepo;
import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.PositionDto;
import com.aqua.prod.entity.Position;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.PositionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionRepo positionRepo;
    private StatusRepo statusRepo;
    private ObjectMapper mapper;

    public PositionServiceImpl(PositionRepo positionRepo, StatusRepo statusRepo, ObjectMapper mapper)
    {
        this.positionRepo = positionRepo;
        this.statusRepo = statusRepo;
        this.mapper = mapper;
    }

    @Override
    public Position createPosition(PositionDto positionDto)
    {
        try {
            return positionRepo.save(mapper.convertValue(positionDto, Position.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Position updatePosition(PositionDto positionDto) throws EntityNotFoundException
    {
        try {
            Optional<Position> position = positionRepo.findById(positionDto.getId());
            Optional<Status> status = statusRepo.findById(positionDto.getStatus());
            if (position.isPresent() && status.isPresent()) {
                position.get().setName(positionDto.getName());
                position.get().setStatus(status.get());
                position.get().setDescription(positionDto.getDescription());
                return positionRepo.save(position.get());
            } else {
                throw new EntityNotFoundException("Position or Status not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Position> checkPositionByName(String name)
    {
        return positionRepo.findByNameIgnoreCase(name);
    }

    @Override
    public Optional<Position> getPositionById(Integer id)
    {
        return positionRepo.findById(id);
    }

    @Override
    public void deletePositionById(Integer id)
    {
        Optional<Position> position = positionRepo.findById(id);
        positionRepo.delete(position.get());
    }
}
