package com.tw.train.restfulapi.security;

import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.repository.TodoRepository;
import com.tw.train.restfulapi.repository.UserRepostiory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class JwtSecurity {
    @Autowired
    private UserRepostiory userRepository;

    public String createSession(User user) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,"mysecret".getBytes())
                .claim("id",user.getId())
                .compact();
    }

    public User getUserFromToken(String signature){
        Claims claims = Jwts.parser()
                .setSigningKey("mysecret".getBytes())
                .parseClaimsJws(signature)
                .getBody();
        Long id = claims.get("id",Long.class);
        return userRepository.findOne(id);
    }
}
