package com.aqua.prod.api.controller;

import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegistrationDto;
import com.aqua.prod.dto.UserDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<JsonResponse<User>> register(@Validated @RequestBody RegistrationDto registrationDto) throws UserExistsException
    {
        User user = userService.register(registrationDto);
        JsonResponse<User> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Registered succssfully");
        jsonResponse.setData(user);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }


    @PostMapping("/login")
    public ResponseEntity<JsonResponse<String>> login(@Validated @RequestBody LoginDto loginDto)
    {
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        String jwtToken = userService.login(loginDto);
        if (jwtToken == null) {
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Invalid credentials");
            return new ResponseEntity<>(jsonResponse, HttpStatus.valueOf(409));
        } else {
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Logged-in successfully");
            jsonResponse.setData(jwtToken);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        }
    }


    @GetMapping("/me")
    public ResponseEntity<JsonResponse<User>> getLoggedInUserProfile(@AuthenticationPrincipal User user)
    {
        JsonResponse<User> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("User fetched successfully");
        jsonResponse.setData(user);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<JsonResponse<UserDto>> updateUserProfile(@AuthenticationPrincipal User user, @RequestBody UserDto userDto) throws Exception
    {
        UserDto updatedUser = userService.updateUserProfile(user, userDto);
        JsonResponse<UserDto> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("User updated successfully");
        jsonResponse.setData(updatedUser);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
