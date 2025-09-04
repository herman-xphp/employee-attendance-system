package com.muslimdev.attendance.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class ShiftResponse {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
}
