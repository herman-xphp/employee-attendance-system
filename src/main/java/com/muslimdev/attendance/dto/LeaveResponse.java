package com.muslimdev.attendance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LeaveResponse {
    private Long id;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status;
    private Long employeeId;
    private String employeeName;
    private Long approvedById;
    private String approvedByName;
}
