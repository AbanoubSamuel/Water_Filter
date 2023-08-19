package com.aqua.prod.api.controller;


import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.PositionDto;
import com.aqua.prod.service.PositionService;
import com.aqua.prod.service.StatusService;
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


    public ResponseEntity<JsonResponse<PositionDto>> getPosition(Integer positionId)
    {
        JsonResponse<PositionDto> jsonResponse = new JsonResponse<>();
        return null;
    }

    public ResponseEntity<JsonResponse<PositionDto>> createPosition(PositionDto createPositionDto)
    {
        JsonResponse<PositionDto> jsonResponse = new JsonResponse<>();
        return null;
    }
}
