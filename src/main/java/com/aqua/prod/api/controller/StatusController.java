package com.aqua.prod.api.controller;


import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    private StatusController(StatusService statusService)
    {
        this.statusService = statusService;
    }


    @GetMapping("/all")
    private ResponseEntity<JsonResponse<List<StatusDto>>> getAllStatuses()
    {
        List<StatusDto> statusDto = statusService.getAllStatuses();
        JsonResponse<List<StatusDto>> jsonResponse = new JsonResponse<>();
        if (!statusDto.isEmpty()) {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Fetched statuses successfully");
            jsonResponse.setData(statusDto);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } else {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("No statuses found");
            return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping()
    private ResponseEntity<JsonResponse<Status>> createStatus(@Valid @RequestBody StatusDto statusDto)
    {
        //// Create new status ////
        Status status = statusService.createStatus(statusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        if (status != null) {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Status created successfully");
            jsonResponse.setData(status);
            return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
        } else {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Failed to create status");
            return new ResponseEntity<>(jsonResponse, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PutMapping()
    private ResponseEntity<JsonResponse<Status>> updateStatus(@Valid @RequestBody StatusDto statusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusDto);
        if (updatedStatus != null) {
            JsonResponse<Status> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Status updated successfully");
            jsonResponse.setData(updatedStatus);
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
        } else {
            JsonResponse<Status> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Failed to update status");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping()
    private ResponseEntity<JsonResponse<Status>> getStatus(@Valid @RequestParam(name = "statusId") Integer statusId)

    {
        Optional<Status> status = statusService.getStatusById(statusId);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        if (status.isPresent()) {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Status fetched successfully");
            jsonResponse.setData(status.get());
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
        } else {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Status not found with " + statusId + " id");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(404));
        }
    }
}
