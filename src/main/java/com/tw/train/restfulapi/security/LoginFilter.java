package com.tw.train.restfulapi.security;

import com.sun.javafx.collections.ImmutableObservableList;
import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.session.SessionStore;
import org.hibernate.annotations.Immutable;
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
    @Autowired
    SessionStore sessionStore;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(token!=null){
            // verify token
//            if(!token.equals("hehe")){
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//            User userFromToken = new User(10L,"hh","1");
            User userFromToken = sessionStore.getUserFromToken(token);

            if(userFromToken!=null){
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userFromToken,"", new ArrayList<>()));
            }
        }

        filterChain.doFilter(request,response);
    }
}
