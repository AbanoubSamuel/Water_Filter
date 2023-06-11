package com.aqua.prod.service;

import com.aqua.prod.entity.Users;

public interface UserService {
    Users getUser(Long id);
    Users getUser(String email);
    void saveUser(Users user);
}