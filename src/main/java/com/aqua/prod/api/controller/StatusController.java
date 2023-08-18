package com.aqua.prod.api.controller;


import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService)
    {
        this.statusService = statusService;
    }

    @PostMapping()
    public ResponseEntity<JsonResponse<Status>> createStatus(
            @Valid
            @RequestBody StatusDto statusDto)
    {
        Optional<Status> statusExists = statusService.checkStatusByName(statusDto.getName());
        if (statusExists.isPresent()) {
            JsonResponse<Status> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Status already exists");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(409));
        }

        //// Create new status ////
        Status status = statusService.createStatus(statusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status created successfully");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<JsonResponse<Status>> updateStatus(
            @Valid @PathVariable Long statusId,
            @Valid @RequestBody StatusDto statusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusId, statusDto);
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
