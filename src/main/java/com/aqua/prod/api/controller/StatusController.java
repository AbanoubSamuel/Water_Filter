package com.aqua.prod.api.controller;


import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.serviceImpl.StatusServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createStatus(@Valid @RequestBody CreateStatusDto createStatusDto)
    {
        Boolean statusExists = statusService.checkStatusByName(createStatusDto.getName());
        if (statusExists) {
            JsonResponse jsonResponse = new JsonResponse();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Status already exists");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(409));
        }


        Status status = statusService.createStatus(createStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status created successfully");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<JsonResponse<Status>> updateStatus(@Valid @PathVariable Long statusId, @Valid @RequestBody UpdateStatusDto updateStatusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusId, updateStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status updated successfully");
        jsonResponse.setData(updatedStatus);

        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse> getStatus(@Valid @PathVariable Long id)
    {
        Optional<Status> status = statusService.getStatusById(id);
        JsonResponse<Object> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Get Status By Id");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }
}
