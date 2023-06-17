package com.aqua.prod.security.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try {
            filterChain.doFilter(request, response);
        } catch (EntityNotFoundException e) {
            sendErrorResponse(response, HttpServletResponse.SC_NOT_FOUND, "User not found");
        } catch (JWTVerificationException e) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "JWT token not found");
        } catch (RuntimeException e) {
            sendErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, "Bad request");
        }
    }

    private void sendErrorResponse(HttpServletResponse response, int statusCode, String errorMessage) throws IOException
    {
        response.setStatus(statusCode);
        response.setContentType("application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);

        String jsonBody = objectMapper.writeValueAsString(errorResponse);

        response.getWriter().write(jsonBody);
        response.getWriter().flush();
    }
}
