package com.aqua.prod.api.controller;

import com.aqua.prod.common.exception.UserExistsException;
import com.aqua.prod.common.respons.BaseResponse;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.dto.UserUpdateDto;
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

    public AuthController(UserServiceImpl userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<User>> register(@Valid @RequestBody RegisterDto registerDto) throws UserExistsException
    {
        User user = userService.register(registerDto);
        BaseResponse<User> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("Registered successfully");
        baseResponse.setData(user);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(201));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String>> login(@Valid @RequestBody LoginDto loginDto)
    {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        String jwtToken = userService.login(loginDto);
        if (jwtToken == null) {
            baseResponse.setStatus(false);
            baseResponse.setMessage("Invalid credentials");
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        } else {
            baseResponse.setStatus(true);
            baseResponse.setMessage("Logged-in successfully");
            baseResponse.setData(jwtToken);
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        }
    }


    @GetMapping("/me")
    public ResponseEntity<BaseResponse<User>> getLoggedInUserProfile(@AuthenticationPrincipal User user)
    {
        BaseResponse<User> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("User fetched successfully");
        baseResponse.setData(user);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<BaseResponse<UserUpdateDto>> updateUserProfile(@AuthenticationPrincipal User user, @RequestBody UserUpdateDto userUpdateDto) throws Exception
    {
        UserUpdateDto updatedUser = userService.updateUserProfile(user, userUpdateDto);
        BaseResponse<UserUpdateDto> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("User updated successfully");
        baseResponse.setData(updatedUser);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
