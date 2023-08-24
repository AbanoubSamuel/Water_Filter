package com.aqua.prod.security.filter;

import com.aqua.prod.datarest.UserRepo;
import com.aqua.prod.entity.User;
import com.aqua.prod.security.SecurityConstants;
import com.aqua.prod.serviceImpl.JWTServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.aqua.prod.security.SecurityConstants.BEARER;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private JWTServiceImpl jwtService;
    private UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "*/*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method");
        String tokenHeader = request.getHeader(SecurityConstants.AUTHORIZATION);
        if (tokenHeader != null && tokenHeader.startsWith(BEARER)) {
            String token = tokenHeader.substring(7);
            try {
                String username = jwtService.getUserName(token);
                Optional<User> optionalUser = userRepo.findByUserNameIgnoreCase(username);
                if (optionalUser.isPresent()) {
                    UsernamePasswordAuthenticationToken authentication = getUsernamePasswordAuthenticationToken(optionalUser);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception exception) {
                logger.error("Invalid token: " + exception.getMessage());
            }
        }
        filterChain.doFilter(request, response);

    }


    private static UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(Optional<User> optionalUser)
    {
        User user = optionalUser.get();
        String roleName = user.getUserType().getRole().getName(); // Get the role name from the user entity
        // Create a SimpleGrantedAuthority using the role name
        GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
        // Create a list of authorities (roles) for the user
        List<GrantedAuthority> authorities = Collections.singletonList(authority);

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
}
