package com.muslimdev.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.attendance.dto.ApiResponse;
import com.muslimdev.attendance.dto.AttendanceRequest;
import com.muslimdev.attendance.dto.AttendanceResponse;
import com.muslimdev.attendance.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public ApiResponse<AttendanceResponse> checkin(@RequestBody AttendanceRequest request) {
        AttendanceResponse response = attendanceService.checkIn(request);
        return ApiResponse.<AttendanceResponse>builder().data(response).build();
    }

    @PostMapping("/checkout")
    public ApiResponse<AttendanceResponse> checkout(@RequestBody AttendanceRequest request) {
        AttendanceResponse response = attendanceService.checkOut(request);
        return ApiResponse.<AttendanceResponse>builder().data(response).build();
    }
}
