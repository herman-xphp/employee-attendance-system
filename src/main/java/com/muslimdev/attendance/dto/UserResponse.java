package com.muslimdev.attendance.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String role;
    private Long employeeId;
    private String employeeName;
}
