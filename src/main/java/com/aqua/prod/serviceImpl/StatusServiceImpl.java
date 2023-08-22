package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepo statusRepo;
    private final ObjectMapper mapper;

    public StatusServiceImpl(StatusRepo statusRepo, ObjectMapper mapper)
    {
        this.statusRepo = statusRepo;
        this.mapper = mapper;
    }


    @Override
    public List<StatusDto> getAllStatuses()
    {
        return statusRepo.findAll().stream().map(status -> mapper.convertValue(status, StatusDto.class)).toList();
    }


    @Override
    public Status createStatus(StatusDto statusDto)
    {
        Optional<Status> existingStatus = checkStatusByName(statusDto.getName());
        if (existingStatus.isPresent()) {
            throw new RuntimeException("Status already exists");
        } else {
            return statusRepo.save(mapper.convertValue(statusDto, Status.class));
        }
    }

    public Optional<Status> checkStatusByName(String name)
    {
        return statusRepo.getStatusByName(name);
    }

    @Override
    public Status updateStatus(StatusDto statusDto)
    {
        Status status = statusRepo.findById(statusDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
        try {
            if (status != null) {
                return statusRepo.save(mapper.convertValue(statusDto, Status.class));
            } else {
                return null;
            }

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Status> getStatusById(Integer statusId)
    {
        return statusRepo.findById(statusId);
    }


}
