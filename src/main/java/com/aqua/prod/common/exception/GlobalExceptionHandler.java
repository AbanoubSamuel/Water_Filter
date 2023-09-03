package com.aqua.prod.common.exception;

import com.aqua.prod.common.respons.JsonResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
            // Handle Entity Not Found Exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Entity not found with this id " + ex.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
        } else if (ex instanceof DataIntegrityViolationException) {
            // Handle Duplicate Entity Exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Entity already exists ! use a different name");
            return new ResponseEntity<>(jsonResponse, HttpStatus.CONFLICT);
        } else if (ex instanceof IllegalArgumentException) {
            // Handle Entity Not Found Exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Entity not found with this id");
            return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
        } else {
            // Handle general  exception
            JsonResponse<String> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}