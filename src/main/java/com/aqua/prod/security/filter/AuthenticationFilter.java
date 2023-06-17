package com.aqua.prod.security.filter;

import com.aqua.prod.entity.Users;
import com.aqua.prod.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            Users user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            return authenticationManager.authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException
    {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String errorMessage = failed.getMessage();
        String jsonBody = objectMapper.writeValueAsString(errorMessage);

        response.getWriter().write(jsonBody);
        response.getWriter().flush();
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException
    {
        String token = JWT.create()
                          .withSubject(authResult.getName())
                          .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION))
                          .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));

        String jsonResponse = createJsonResponse(token);
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

    private String createJsonResponse(String token) throws IOException
    {
        Gson json = new Gson();
        Map<String, Object> response = Map.of(
                "status", true,
                "message", "User logged in successfully",
                "token", SecurityConstants.BEARER + token
        );
        return json.toJson(response);
    }
}
