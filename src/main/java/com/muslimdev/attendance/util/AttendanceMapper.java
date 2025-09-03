package com.muslimdev.attendance.util;

import com.muslimdev.attendance.dto.AttendanceResponse;
import com.muslimdev.attendance.entity.Attendance;

public class AttendanceMapper {
    public static AttendanceResponse toDto(Attendance attendance) {
        AttendanceResponse dto = new AttendanceResponse();
        dto.setId(attendance.getId());
        dto.setEmployeeId(attendance.getEmployee().getId());
        dto.setEmployeeName(attendance.getEmployee().getFullName());
        dto.setCheckIn(attendance.getCheckIn());
        dto.setCheckOut(attendance.getCheckout());
        dto.setStatus(attendance.getStatus().toString());
        return dto;
    }
}
