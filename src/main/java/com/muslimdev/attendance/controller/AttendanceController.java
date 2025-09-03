package com.muslimdev.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<AttendanceResponse>> checkin(@RequestBody AttendanceRequest request) {
        AttendanceResponse response = attendanceService.checkIn(request);

        return ResponseEntity.ok(
                new ApiResponse<>("success", response));
    }

    @PostMapping("/checkout")
    public ResponseEntity<ApiResponse<AttendanceResponse>> checkout(@RequestBody AttendanceRequest request) {
        AttendanceResponse response = attendanceService.checkOut(request);
        return ResponseEntity.ok(
                new ApiResponse<>("success", response));
    }
}
