package com.aqua.prod.api.controller;

import com.aqua.prod.common.exception.UserExistsException;
import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.dto.UserDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;

    private AuthController(UserServiceImpl userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<JsonResponse<User>> register(@Valid @RequestBody RegisterDto registerDto) throws UserExistsException
    {
        User user = userService.register(registerDto);
        JsonResponse<User> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Registered successfully");
        jsonResponse.setData(user);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PostMapping("/login")
    private ResponseEntity<JsonResponse<String>> login(@Valid @RequestBody LoginDto loginDto)
    {
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        String jwtToken = userService.login(loginDto);
        if (jwtToken == null) {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Invalid credentials");
            return new ResponseEntity<>(jsonResponse, HttpStatus.BAD_REQUEST);
        } else {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Logged-in successfully");
            jsonResponse.setData(jwtToken);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        }
    }


    @GetMapping("/me")
    private ResponseEntity<JsonResponse<User>> getLoggedInUserProfile(@AuthenticationPrincipal User user)
    {
        JsonResponse<User> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("User fetched successfully");
        jsonResponse.setData(user);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }


    @PutMapping("/update")
    private ResponseEntity<JsonResponse<UserDto>> updateUserProfile(@AuthenticationPrincipal User user, @RequestBody UserDto userDto) throws Exception
    {
        UserDto updatedUser = userService.updateUserProfile(user, userDto);
        JsonResponse<UserDto> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("User updated successfully");
        jsonResponse.setData(updatedUser);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
