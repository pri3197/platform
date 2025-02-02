package com.gala.standardization.platform.security;


import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired private CustomDetailsService userDetailsService;
    @Autowired private JWTUtil jwtUtil;

   
    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
            throws jakarta.servlet.ServletException, IOException {

                String authHeader = request.getHeader("Authorization");
                if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
                    String jwt = authHeader.substring(7);
                   
                        try{
                            String username = jwtUtil.validateTokenAndRetrieveSubject(jwt);
                            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                            UsernamePasswordAuthenticationToken authToken =
                                    new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                            if(SecurityContextHolder.getContext().getAuthentication() == null){
                                SecurityContextHolder.getContext().setAuthentication(authToken);
                            }
                        }catch(JWTVerificationException exc){
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
                            return;
                        }
                
                }
        
                filterChain.doFilter(request, response);
      
    }
}