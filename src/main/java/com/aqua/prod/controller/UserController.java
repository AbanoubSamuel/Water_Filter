package com.aqua.prod.controller;

import com.aqua.prod.entity.Users;
import com.aqua.prod.model.JsonResponse;
import com.aqua.prod.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.getUser(id).getUserName(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/register")
    public ResponseEntity<JsonResponse> createUser(@Valid @RequestBody Users user)
    {
        Users savedUser = userService.saveUser(user);
        // Create a custom response map with the desired fields
        JsonResponse<Users> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("User successfully registered");
        jsonResponse.setData(savedUser);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

}
