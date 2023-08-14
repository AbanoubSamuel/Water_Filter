package com.aqua.prod.service;

import com.aqua.prod.entity.User;

public interface JWTService {
    String generateJWT(User user);

    String getUserName(String token);
}
