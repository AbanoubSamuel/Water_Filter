package com.aqua.prod.service;

import com.aqua.prod.common.exception.UserExistsException;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.dto.UserDto;
import com.aqua.prod.entity.User;

public interface UserService {
    String login(LoginDto loginDto);
    User register(RegisterDto registerDto) throws UserExistsException;

    UserDto updateUserProfile(User user, UserDto userDto) throws Exception;
}