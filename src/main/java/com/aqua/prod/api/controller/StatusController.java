package com.aqua.prod.api.controller;


import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.serviceImpl.StatusServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusServiceImpl statusService;

    public StatusController(StatusServiceImpl statusService)
    {
        this.statusService = statusService;
    }

    @PostMapping()
    public ResponseEntity<JsonResponse<Status>> createStatus(
            @Valid
            @RequestBody CreateStatusDto createStatusDto)
    {
        Optional<Status> statusExists = statusService.checkStatusByName(createStatusDto.getName());
        if (statusExists.isPresent()) {
            JsonResponse<Status> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Status already exists");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(409));
        }

        //// Create new status ////
        Status status = statusService.createStatus(createStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status created successfully");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<JsonResponse<Status>> updateStatus(
            @Valid @PathVariable Long statusId,
            @Valid @RequestBody UpdateStatusDto updateStatusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusId, updateStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status updated successfully");
        jsonResponse.setData(updatedStatus);

        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping()
    @PreAuthorize("('ROLE_admin')")
    public ResponseEntity<JsonResponse<Optional<Status>>> getStatus(@Valid @RequestParam("statusId") Long statusId)
    {
        Optional<Status> status = statusService.getStatusById(statusId);

        JsonResponse<Optional<Status>> jsonResponse = new JsonResponse<>();
        if (status.isPresent()) {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Fetched status successfully");
            jsonResponse.setData(status);
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
        } else {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Status not found with " + statusId + " id");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(404));
        }
    }
}
