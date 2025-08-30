package com.muslimdev.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muslimdev.attendance.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
