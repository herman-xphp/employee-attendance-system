package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeShiftResponse {
    private Long id;
    private LocalDate date;
    private Long employeeId;
    private String employeeName;
    private Long shiftId;
    private String shiftName;
}
