package com.octo.octoTestProject.controller;

import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.UserDto;
import com.octo.octoTestProject.model.vm.JwtToken;
import com.octo.octoTestProject.model.vm.ReqSignIn;
import com.octo.octoTestProject.security.JwtTokenProvider;
import com.octo.octoTestProject.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * User login
     */
    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody @Valid ReqSignIn request) {
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(((User) authentication.getPrincipal()));
        return ResponseEntity.ok(new JwtToken(token));
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid UserDto dto) {
        log.debug("success added");
        return authService.registerUser(dto);
    }

}
