package com.aqua.prod.service;

import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    Status createStatus(StatusDto statusDto);

    Optional<Status> checkStatusByName(String name);

    Status updateStatus(Integer statusId, StatusDto statusDto);

    Optional<Status> getStatusById(Integer statusId);

    List<StatusDto> getAllStatus();
}
