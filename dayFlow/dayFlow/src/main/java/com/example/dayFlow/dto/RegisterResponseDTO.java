package com.example.dayFlow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterResponseDTO {

    private String employeeId;
    private String email;
    private String role;
}
