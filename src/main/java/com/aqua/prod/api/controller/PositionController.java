package com.aqua.prod.api.controller;


import com.aqua.prod.dto.CreatePositionDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.service.PositionService;
import com.aqua.prod.service.StatusService;
import com.aqua.prod.serviceImpl.PositionServiceImpl;
import com.aqua.prod.serviceImpl.StatusServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;
    private StatusService statusService;
    public PositionController(PositionService positionService, StatusService statusService)
    {
        this.positionService = positionService;
        this.statusService = statusService;
    }

    public ResponseEntity<JsonResponse> createPosition(CreatePositionDto createPositionDto)
    {

        return null;
    }
}
