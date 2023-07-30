package com.aqua.prod.service;

import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.exception.UserExistsException;

public interface UserService {
    String login(LoginDto loginDto);
    User register(RegisterDto registerDto) throws UserExistsException;
}