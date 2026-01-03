package com.example.dayFlow.controller;

import com.example.dayFlow.dto.LoginRequestDTO;
import com.example.dayFlow.dto.LoginResponseDTO;
import com.example.dayFlow.dto.RegisterRequestDTO;
import com.example.dayFlow.dto.RegisterResponseDTO;
import com.example.dayFlow.res.Response;
import com.example.dayFlow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Response<RegisterResponseDTO>> register(
            @RequestBody RegisterRequestDTO request
    ) {
        Response<RegisterResponseDTO> response = authService.register(request);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponseDTO>> login(
            @RequestBody LoginRequestDTO request
    ) {
        Response<LoginResponseDTO> response = authService.login(request);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
