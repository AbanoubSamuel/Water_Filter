package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepo statusRepo;

    public StatusServiceImpl(StatusRepo statusRepo)
    {
        this.statusRepo = statusRepo;
    }

    @Override
    public Status createStatus(StatusDto statusDto)
    {
        Status status = new Status();
        status.setName(statusDto.getName());
        status.setIsActive(statusDto.getIsActive());
        status.setDescription(statusDto.getDescription());
        statusRepo.save(status);
        return statusRepo.save(status);
    }

    public Optional<Status> checkStatusByName(String name)
    {
        return statusRepo.getStatusByName(name);
    }

    @Override
    public Status updateStatus(Integer statusId, StatusDto statusDto)
    {
        Status status = statusRepo.findById(statusId)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
        status.setName(statusDto.getName());
        status.setIsActive(statusDto.getIsActive());
        status.setDescription(statusDto.getDescription());

        return statusRepo.save(status);
    }

    @Override
    public Optional<Status> getStatusById(Integer statusId)
    {
        return statusRepo.findById(statusId);
    }
}
