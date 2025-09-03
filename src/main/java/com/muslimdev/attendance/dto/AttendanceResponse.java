package com.muslimdev.attendance.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AttendanceResponse {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String status;
}
