package com.manudev.Trading.userService.controller;

import com.manudev.Trading.userService.dto.AuthLoginRequestDTO;
import com.manudev.Trading.userService.dto.AuthResponseDTO;
import com.manudev.Trading.userService.service.impl.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserDetailsServiceImpl userDetailsService;

    public ResponseEntity<AuthResponseDTO> Login(@RequestBody @Valid AuthLoginRequestDTO userRequest) {
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }
}
