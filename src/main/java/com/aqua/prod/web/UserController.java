package com.aqua.prod.web;

import com.aqua.prod.entity.Users;
import com.aqua.prod.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.getUser(id).getUserName(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody Users user)
    {
        userService.saveUser(user);
        // Create a custom response map with the desired fields
        Map<String, Object> response = Map.of(
                "status", true,
                "message", "User successfully registration",
                "user", user
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
