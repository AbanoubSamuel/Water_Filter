package com.aqua.prod.api.controller;


import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Status;
import com.aqua.prod.serviceImpl.StatusServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusServiceImpl statusService;

    public StatusController(StatusServiceImpl statusService)
    {
        this.statusService = statusService;
    }

    @PostMapping("/")
    public ResponseEntity<JsonResponse<Status>> createStatus(@AuthenticationPrincipal @Validated @RequestBody CreateStatusDto createStatusDto)
    {
        System.out.println("Status");
        Status status = statusService.createStatus(createStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status created successfully");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<JsonResponse<Status>> updateStatus(@Validated @PathVariable Long statusId, @Valid @RequestBody UpdateStatusDto updateStatusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusId, updateStatusDto);
        JsonResponse<Status> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status updated successfully");
        jsonResponse.setData(updatedStatus);

        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get")
    public ResponseEntity<JsonResponse> getStatus()
    {
        JsonResponse<Object> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Status controller");
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }
}
