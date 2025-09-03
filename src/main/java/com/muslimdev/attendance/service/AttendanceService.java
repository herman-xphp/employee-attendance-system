package com.muslimdev.attendance.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muslimdev.attendance.dto.AttendanceRequest;
import com.muslimdev.attendance.dto.AttendanceResponse;
import com.muslimdev.attendance.entity.Attendance;
import com.muslimdev.attendance.entity.Employee;
import com.muslimdev.attendance.enums.AttendanceStatus;
import com.muslimdev.attendance.repository.AttendanceRepository;
import com.muslimdev.attendance.repository.EmployeeRepository;
import com.muslimdev.attendance.util.AttendanceMapper;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final LocalTime WORK_START = LocalTime.of(8, 0);
    private static final LocalTime WORK_END = LocalTime.of(17, 0);

    public AttendanceResponse checkIn(AttendanceRequest request) {
        Employee employee = employeeRepository.findByEmployeeCode(request.getEmployeeCode())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        attendanceRepository.findByEmployeeIdAndCheckInBetween(employee.getId(), startOfDay, endOfDay).ifPresent(a -> {
            throw new RuntimeException("Already checked in today");
        });

        LocalDateTime now = LocalDateTime.now();
        AttendanceStatus status;

        if (now.toLocalTime().isAfter(WORK_START)) {
            status = AttendanceStatus.LATE;
        } else {
            status = AttendanceStatus.PRESENT;
        }

        Attendance attendance = Attendance.builder()
                .employee(employee)
                .checkIn(LocalDateTime.now())
                .status(status)
                .build();

        Attendance saved = attendanceRepository.save(attendance);

        return AttendanceMapper.toDto(saved);
    }

    public AttendanceResponse checkOut(AttendanceRequest request) {
        Employee employee = employeeRepository.findByEmployeeCode(request.getEmployeeCode())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Attendance attendance = attendanceRepository
                .findByEmployeeIdAndCheckInBetween(employee.getId(), startOfDay, endOfDay)
                .orElseThrow(() -> new RuntimeException("check-in not found for today"));

        if (attendance.getCheckout() != null) {
            throw new RuntimeException("Already checked out today");
        }

        LocalDateTime now = LocalDateTime.now();
        attendance.setCheckout(now);

        if (now.toLocalTime().isBefore(WORK_END)) {
            attendance.setStatus(AttendanceStatus.EARLY_LEAVE);
        }

        Attendance saved = attendanceRepository.save(attendance);

        return AttendanceMapper.toDto(saved);
    }
}
