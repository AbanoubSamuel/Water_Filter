package com.aqua.prod.service;

import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;

import java.util.Optional;

public interface StatusService {

    Status createStatus(CreateStatusDto createStatusDto);

    Optional<Status> checkStatusByName(String name);

    Status updateStatus(Long statusId, UpdateStatusDto updateStatusDto);

    Optional<Status> getStatusById(Long statusId);
}
