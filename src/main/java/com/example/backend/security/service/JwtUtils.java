package com.example.backend.security.service;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {

    private String secret = "thisisoursecret";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 200000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public Claims parseBody(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


    //todo
    public boolean validateToken(String token, HttpServletRequest httpServletRequest){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            System.out.println("Invalid JWT signature");
        }catch (MalformedJwtException e) {
            System.out.println("Invalid JWT");
        }catch (ExpiredJwtException e) {
            System.out.println("Expired JWT");
            httpServletRequest.setAttribute("expired", e.getMessage());
        }catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT exception");
        }catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty");
        }
        return false;
    }

}
