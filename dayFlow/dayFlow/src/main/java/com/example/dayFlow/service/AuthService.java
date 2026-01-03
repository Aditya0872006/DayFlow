package com.example.dayFlow.service;

import com.example.dayFlow.dto.LoginRequestDTO;
import com.example.dayFlow.dto.LoginResponseDTO;
import com.example.dayFlow.dto.RegisterRequestDTO;
import com.example.dayFlow.dto.RegisterResponseDTO;
import com.example.dayFlow.models.User;
import com.example.dayFlow.Repository.UserRepository;
import com.example.dayFlow.res.Response;
import com.example.dayFlow.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // ================= REGISTER =================
    public Response<RegisterResponseDTO> register(RegisterRequestDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return Response.<RegisterResponseDTO>builder()
                    .statusCode(400)
                    .message("Email already exists")
                    .build();
        }

        if (userRepository.existsByEmployeeId(request.getEmployeeId())) {
            return Response.<RegisterResponseDTO>builder()
                    .statusCode(400)
                    .message("Employee ID already exists")
                    .build();
        }

        User user = User.builder()
                .employeeId(request.getEmployeeId())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        RegisterResponseDTO responseDTO = RegisterResponseDTO.builder()
                .employeeId(user.getEmployeeId())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();

        return Response.<RegisterResponseDTO>builder()
                .statusCode(201)
                .message("User registered successfully")
                .data(responseDTO)
                .build();
    }

    // ================= LOGIN =================
    public Response<LoginResponseDTO> login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user.getEmail());

        LoginResponseDTO responseDTO = LoginResponseDTO.builder()
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(token)
                .build();

        return Response.<LoginResponseDTO>builder()
                .statusCode(200)
                .message("Login successful")
                .data(responseDTO)
                .build();
    }
}
