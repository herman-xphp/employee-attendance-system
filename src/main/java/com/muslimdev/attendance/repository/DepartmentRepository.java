package com.muslimdev.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muslimdev.attendance.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
