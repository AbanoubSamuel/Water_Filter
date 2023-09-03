package com.aqua.prod.api.controller;


import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.dto.PositionDto;
import com.aqua.prod.entity.Position;
import com.aqua.prod.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService)
    {
        this.positionService = positionService;
    }


    @GetMapping
    public ResponseEntity<JsonResponse<Position>> getPosition(@Valid @RequestParam(name = "id") Integer id)
    {
        try {
            Optional<Position> position = positionService.getPositionById(id);
            JsonResponse<Position> jsonResponse = new JsonResponse<>();
            if (position.isPresent()) {
                jsonResponse.setStatus(true);
                jsonResponse.setMessage("Fetched position successfully");
                jsonResponse.setData(position.get());
                return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
            } else {
                jsonResponse.setStatus(false);
                jsonResponse.setMessage("Position not found successfully");
                return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            JsonResponse<Position> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping
    public ResponseEntity<JsonResponse<Position>> createPosition(@RequestBody PositionDto positionDto)
    {
        try {
            Optional<Position> existingPosition = positionService.checkPositionByName(positionDto.getName());
            JsonResponse<Position> jsonResponse = new JsonResponse<>();

            if (existingPosition.isPresent()) {
                jsonResponse.setStatus(false);
                jsonResponse.setMessage("Position already exists");
                return new ResponseEntity<>(jsonResponse, HttpStatus.CONFLICT);
            }
            Position position = positionService.createPosition(positionDto);
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Successfully created position");
            jsonResponse.setData(position);
            return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            JsonResponse<Position> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Failed to create position");
            return new ResponseEntity<>(jsonResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PutMapping
    public ResponseEntity<JsonResponse<Position>> updatePosition(@RequestBody PositionDto positionDto)
    {
        try {
            JsonResponse<Position> jsonResponse = new JsonResponse<>();
            Position position = positionService.updatePosition(positionDto);
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Successfully updated position");
            jsonResponse.setData(position);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            JsonResponse<Position> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Position or Status not found");
            return new ResponseEntity<>(jsonResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @DeleteMapping
    public ResponseEntity<JsonResponse<String>> deletePosition(@RequestParam(name = "id") Integer id)
    {
        positionService.deletePositionById(id);
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Position deleted successfully");
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
