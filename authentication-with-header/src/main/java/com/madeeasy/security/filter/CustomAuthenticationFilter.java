package com.madeeasy.security.filter;

import com.madeeasy.security.manager.CustomAuthenticationManager;
import com.madeeasy.security.token.CustomAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomAuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String secretKey = request.getHeader("key");

        CustomAuthenticationToken token = new CustomAuthenticationToken(false, secretKey);
        Authentication authResult = authenticationManager.authenticate(token);
        if (authResult.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authResult);
            filterChain.doFilter(request, response);
        }
    }

}
