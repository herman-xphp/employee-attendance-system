package com.muslimdev.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muslimdev.attendance.dto.EmployeeRequest;
import com.muslimdev.attendance.entity.Employee;
import com.muslimdev.attendance.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .employeeCode(request.getEmployeeCode())
                .position(request.getPosition())
                .joinDate(request.getJoinDate())
                .active(true)
                .build();

        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
