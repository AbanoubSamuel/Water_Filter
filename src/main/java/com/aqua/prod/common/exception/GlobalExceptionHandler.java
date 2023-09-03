package com.aqua.prod.common.exception;

import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.entity.Position;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonResponse<String>> handleException(Exception ex)
    {
        if (ex instanceof EntityNotFoundException) {
            // Handle specific exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Entity not found with this id");
            return new ResponseEntity<>(jsonResponse, HttpStatus.CONFLICT);
        } else if (ex instanceof EntityExistsException) {
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Entity already exists");
            return new ResponseEntity<>(jsonResponse, HttpStatus.CONFLICT);
        } else {
            // Handle another specific exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}