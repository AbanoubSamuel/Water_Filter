package com.aqua.prod.security.filter;

import com.aqua.prod.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String bearerToken = request.getHeader(SecurityConstants.AUTHORIZATION);

        if (bearerToken == null || !bearerToken.startsWith(SecurityConstants.BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = bearerToken.replace(SecurityConstants.BEARER, "");

        String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                         .build()
                         .verify(token)
                         .getSubject();

        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(user, null, List.of());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

        String jsonResponse = createJsonResponseWithToken(token);
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

    private String createJsonResponseWithToken(String token) throws IOException
    {
        Gson json = new Gson();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("token", token);
        return json.toJson(jsonResponse);
    }
}
