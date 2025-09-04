package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OvertimeResponse {
    private Long id;
    private LocalDate date;
    private Integer hours;
    private String reason;
    private Long employeeId;
    private String employeeName;
}
