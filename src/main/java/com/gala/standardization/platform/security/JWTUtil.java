package com.gala.standardization.platform.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gala.standardization.platform.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.util.Base64;
import java.util.Date;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

import java.security.Key;
@Component
public class JWTUtil {


  @Value("${jwt_secret}")
   private String secret;
   private Key key;
   private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
  @PostConstruct
    public void init() {
        if (secret == null) {
            throw new IllegalStateException("jwt_secret property must be set!"); // Handle missing secret
        }
        byte[] secretBytes = Base64.getDecoder().decode(secret);
        this.key = Keys.hmacShaKeyFor(secretBytes);
    }
    public String generateToken(String username, Role role) throws IllegalArgumentException, JWTCreationException {
        //System.out.println("Generated Secret Key: " + secret);

        return Jwts.builder()
        .setSubject(username)
        .claim("roles", role.name())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
    }


    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
        Claims claims = Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();
    return claims.getSubject();
    }

    public Role getRoleFromToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody();
        return Role.valueOf(claims.get("role", String.class)); // Convert role back to Enum
    }

}
