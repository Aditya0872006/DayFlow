package com.example.dayFlow.dto;

import com.example.dayFlow.models.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String employeeId;
    private String email;
    private String password;
    private Role role;   // ADMIN / EMPLOYEE
}
