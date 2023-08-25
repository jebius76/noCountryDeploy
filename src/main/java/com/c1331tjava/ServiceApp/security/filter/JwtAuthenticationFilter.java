package com.c1331tjava.ServiceApp.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import com.c1331tjava.ServiceApp.model.UserEntity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This filter handles authentication attempts using JWT tokens.
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtUtil jwtUtil;

    /**
     * Constructs a JwtAuthenticationFilter with the given JwtUtil instance.
     *
     * @param jwtUtil The JwtUtil instance for generating JWT tokens.
     */
    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Attempts user authentication based on the provided credentials.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @return An Authentication object representing the user's authentication status.
     * @throws AuthenticationException If an authentication error occurs.
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UserEntity userEntity = null;
        String username = "";
        String password = "";

        try {
            userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
            username = userEntity.getUserName();
            password = userEntity.getPassword();
        } catch (IOException se) {
            se.printStackTrace();
            throw new RuntimeException("Error al leer el cuerpo de la solicitud", se);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    /**
     * Handles successful authentication by generating a JWT token and providing a response with token information.
     *
     * @param request     The HTTP request object.
     * @param response    The HTTP response object.
     * @param chain       The filter chain.
     * @param authResult  The authentication result.
     * @throws IOException      If an I/O error occurs.
     * @throws ServletException If a servlet error occurs.
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = jwtUtil.generateAccesToken(user.getUsername());
        response.addHeader("Authorization", token);

        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("message", "Correct Authentication");
        httpResponse.put("username", user.getUsername());

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}

