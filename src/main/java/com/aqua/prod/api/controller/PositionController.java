package com.aqua.prod.api.controller;


import com.aqua.prod.dto.CreatePositionDto;
import com.aqua.prod.dto.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
public class PositionController {

    public ResponseEntity<JsonResponse> createPosition(CreatePositionDto createPositionDto)
    {

        return null;
    }
}
