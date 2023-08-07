package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepo statusRepo;

    public StatusServiceImpl(StatusRepo statusRepo)
    {
        this.statusRepo = statusRepo;
    }

    public Status createStatus(CreateStatusDto createStatusDto)
    {
        Status status = new Status();
        status.setName(createStatusDto.getName());
        status.setIsActive(createStatusDto.getIsActive());
        status.setDescription(createStatusDto.getDescription());
        statusRepo.save(status);
        return statusRepo.save(status);
    }

    public Status updateStatus(Long statusId, UpdateStatusDto updateStatusDto)
    {
        Status existingStatus = statusRepo.findById(statusId)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));

        existingStatus.setName(updateStatusDto.getName());
        existingStatus.setIsActive(updateStatusDto.getIsActive());
        existingStatus.setDescription(updateStatusDto.getDescription());

        return statusRepo.save(existingStatus);
    }
}
