package com.aqua.prod.serviceImpl;

import com.aqua.prod.entity.User;
import com.aqua.prod.service.JWTService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;
    private static final String USERNAME_KEY = "USERNAME";
    private static final String ROLE = "Role_";

    @PostConstruct
    public void postConstruct()
    {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    @Override
    public String generateJWT(User user)
    {
        int expiryInDays = 7;
        expiryInSeconds = expiryInDays * 24 * 60 * 60; // Convert days to seconds

        String roleName = user.getUserType().getRole().getName();
        System.out.println("Role_" + roleName);
        return JWT.create()
                .withClaim(USERNAME_KEY, user.getUserName())
                .withClaim(ROLE, roleName)
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000L * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    @Override
    public String getUserName(String token)
    {
        DecodedJWT jwt = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return jwt.getClaim(USERNAME_KEY).asString();
    }
}
