package com.muslimdev.attendance.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String role;
    private Long employeeId;
}
