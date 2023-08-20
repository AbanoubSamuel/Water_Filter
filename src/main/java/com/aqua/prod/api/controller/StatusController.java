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

    public StatusController(StatusService statusService)
    {
        this.statusService = statusService;
    }


    @GetMapping()
    public ResponseEntity<BaseResponse<List<StatusDto>>> getAllStatuses()
    {
        List<StatusDto> statusDto = statusService.getAllStatus();
        BaseResponse<List<StatusDto>> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("Fetched statuses successfully");
        baseResponse.setData(statusDto);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<Status>> createStatus(
            @Valid
            @RequestBody StatusDto statusDto)
    {
        Optional<Status> statusExists = statusService.checkStatusByName(statusDto.getName());
        if (statusExists.isPresent()) {
            BaseResponse<Status> baseResponse = new BaseResponse<>();
            baseResponse.setStatus(false);
            baseResponse.setMessage("Status already exists");
            return new ResponseEntity<>(baseResponse, HttpStatus.CONFLICT);
        }

        //// Create new status ////
        Status status = statusService.createStatus(statusDto);
        BaseResponse<Status> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("Status created successfully");
        baseResponse.setData(status);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<BaseResponse<Status>> updateStatus(
            @Valid @PathVariable Integer statusId,
            @Valid @RequestBody StatusDto statusDto)
    {
        Status updatedStatus = statusService.updateStatus(statusId, statusDto);
        BaseResponse<Status> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("Status updated successfully");
        baseResponse.setData(updatedStatus);

        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{statusId}")
    @PreAuthorize("('ROLE_admin')")
    public ResponseEntity<BaseResponse<Optional<Status>>> getStatus(@Valid @RequestParam("statusId") Integer statusId)
    {
        Optional<Status> status = statusService.getStatusById(statusId);

        BaseResponse<Optional<Status>> baseResponse = new BaseResponse<>();
        if (status.isPresent()) {
            baseResponse.setStatus(true);
            baseResponse.setMessage("Fetched status successfully");
            baseResponse.setData(status);
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
        } else {
            baseResponse.setStatus(false);
            baseResponse.setMessage("Status not found with " + statusId + " id");
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(404));
        }
    }
}
