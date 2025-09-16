package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String employeeCode;
    private String position;
    private LocalDate joinDate;
    private Boolean active;
    private Long departmentId;
    private String departmentName;
}
