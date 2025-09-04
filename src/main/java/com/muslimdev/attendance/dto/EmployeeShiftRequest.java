package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeShiftRequest {
    private Long employeeId;
    private Long shiftId;
    private LocalDate date;
}
