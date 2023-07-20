package com.aqua.prod.service;

import com.aqua.prod.dto.LoginDto;

public interface UserService {
//    User saveUser(User user);

    String login(LoginDto loginDto);
}