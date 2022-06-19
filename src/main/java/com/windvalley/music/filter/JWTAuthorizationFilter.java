package com.windvalley.music.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.windvalley.music.common.base.config.SecurityConfig;
import com.windvalley.music.entity.Role;
import com.windvalley.music.service.IRoleService;
import com.windvalley.music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private IRoleService roleService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, IRoleService roleService) {
        super(authenticationManager);
        this.roleService = roleService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConfig.HEADER_STRING);

        if (header == null || header.startsWith(SecurityConfig.TOKEN_PREFIX) == false) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(header);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        String userName = JWT.require(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()))
                .build()
                .verify(header.replace(SecurityConfig.TOKEN_PREFIX, ""))
                .getSubject();

        if (userName != null){
            List<Role> roles = roleService.getRolesByUserName(userName);

            List<SimpleGrantedAuthority> collect = new ArrayList<SimpleGrantedAuthority>();
            for (Role role : roles){
                collect.add(new SimpleGrantedAuthority(role.getName()));
            }

            return new UsernamePasswordAuthenticationToken(userName, null, collect);
        }

        return null;
    }
}


