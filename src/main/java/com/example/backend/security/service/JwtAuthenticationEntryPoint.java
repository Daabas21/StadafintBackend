//package com.example.backend.security.service;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Objects;
//
////todo
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response,
//                         AuthenticationException authException) throws IOException, ServletException {
//        final String expired = (String) request.getAttribute("expired");
//        System.out.println(expired);
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                Objects.requireNonNullElse(expired, "Invalid Login details"));
//    }
//}
