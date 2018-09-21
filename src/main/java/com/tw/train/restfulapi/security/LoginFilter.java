package com.tw.train.restfulapi.security;

import com.tw.train.restfulapi.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class LoginFilter extends OncePerRequestFilter {
//    @Autowired
//    SessionStore sessionStore;

    @Autowired
    JwtSecurity jwtSecurity;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
//            User userFromToken = sessionStore.getUserFromToken(token);
            User userFromToken = jwtSecurity.getUserFromToken(token);

            if (userFromToken != null) {
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userFromToken, "", new ArrayList<>()));
            }
        }

        filterChain.doFilter(request, response);
    }
}
