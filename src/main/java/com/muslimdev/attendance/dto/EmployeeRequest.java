package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String employeeCode;
    private String position;
    private LocalDate joinDate;
}
