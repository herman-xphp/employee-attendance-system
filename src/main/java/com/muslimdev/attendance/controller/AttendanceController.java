package com.muslimdev.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.attendance.dto.AttendanceRequest;
import com.muslimdev.attendance.entity.Attendance;
import com.muslimdev.attendance.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public ResponseEntity<Attendance> checkin(@RequestBody AttendanceRequest request) {
        Attendance attendance = attendanceService.checkIn(request);
        return new ResponseEntity<>(attendance, HttpStatus.CREATED);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Attendance> checkout(@RequestBody AttendanceRequest request) {
        Attendance attendance = attendanceService.checkOut(request);
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }
}
