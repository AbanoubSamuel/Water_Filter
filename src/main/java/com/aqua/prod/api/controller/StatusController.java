package com.aqua.prod.api.controller;


import com.aqua.prod.dto.StatusDto;
import com.aqua.prod.common.respons.BaseResponse;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @GetMapping()
    private ResponseEntity<BaseResponse<List<StatusDto>>> getAllStatuses()
    {
        List<StatusDto> statusDto = statusService.getAllStatuses();
        BaseResponse<List<StatusDto>> baseResponse = new BaseResponse<>();
        if (!statusDto.isEmpty()) {
            baseResponse.setStatus(true);
            baseResponse.setMessage("Fetched statuses successfully");
            baseResponse.setData(statusDto);
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        } else {
            baseResponse.setStatus(false);
            baseResponse.setMessage("No statuses found");
            return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping()
    private ResponseEntity<BaseResponse<Status>> createStatus(@Valid @RequestBody StatusDto statusDto)
    {
        //// Create new status ////
        Status status = statusService.createStatus(statusDto);
        BaseResponse<Status> baseResponse = new BaseResponse<>();
        if (status != null) {
            baseResponse.setStatus(true);
            baseResponse.setMessage("Status created successfully");
            baseResponse.setData(status);
            return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
        } else {
            baseResponse.setStatus(false);
            baseResponse.setMessage("Failed to create status");
            return new ResponseEntity<>(baseResponse, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PutMapping()
    private ResponseEntity<BaseResponse<Status>> updateStatus(@Valid @RequestBody StatusDto statusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusDto);
        if (updatedStatus != null) {
            BaseResponse<Status> baseResponse = new BaseResponse<>();
            baseResponse.setStatus(true);
            baseResponse.setMessage("Status updated successfully");
            baseResponse.setData(updatedStatus);
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
        } else {
            BaseResponse<Status> baseResponse = new BaseResponse<>();
            baseResponse.setStatus(false);
            baseResponse.setMessage("Failed to update status");
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping("/get{statusId}")
    private ResponseEntity<BaseResponse<Status>> getStatus(@Valid @RequestParam(name = "statusId") Integer statusId)

    {
        Optional<Status> status = statusService.getStatusById(statusId);
        BaseResponse<Status> baseResponse = new BaseResponse<>();
        if (status.isPresent()) {
            baseResponse.setStatus(true);
            baseResponse.setMessage("Status fetched successfully");
            baseResponse.setData(status.get());
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
        } else {
            baseResponse.setStatus(false);
            baseResponse.setMessage("Status not found with " + statusId + " id");
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(404));
        }
    }
}
