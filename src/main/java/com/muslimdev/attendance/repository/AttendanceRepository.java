package com.muslimdev.attendance.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muslimdev.attendance.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByEmployeeIdAndCheckInBetween(Long employeeId, LocalDateTime startOfDay,
            LocalDateTime endOfDay);

}
