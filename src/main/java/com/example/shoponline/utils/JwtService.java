package com.example.shoponline.utils;

import com.example.shoponline.entities.Utilizator;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}") // Secret key from application.properties
    private String secretKey;

    @Value("${jwt.expiration}") // Token expiration in milliseconds
    private long jwtExpirationMillis;

    // Generate JWT token
    public String generateToken(Utilizator user) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("name", user.getNume())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMillis))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate and parse JWT token
    public Claims validateToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}