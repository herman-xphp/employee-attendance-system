package com.muslimdev.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muslimdev.attendance.dto.EmployeeRequest;
import com.muslimdev.attendance.dto.EmployeeResponse;
import com.muslimdev.attendance.entity.Employee;
import com.muslimdev.attendance.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setPosition(request.getPosition());
        employee.setJoinDate(request.getJoinDate());
        employee.setDepartment(request.getDepartment());

        employeeRepository.save(employee);

        return EmployeeResponse.builder()
                .fullName(employee.getFullName())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .employeeCode(employee.getEmployeeCode())
                .position(employee.getPosition())
                .joinDate(employee.getJoinDate())
                .departmentId(employee.getDepartment().getId())
                .build();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
