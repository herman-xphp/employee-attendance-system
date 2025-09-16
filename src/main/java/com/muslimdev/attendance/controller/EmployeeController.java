package com.muslimdev.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.attendance.dto.ApiResponse;
import com.muslimdev.attendance.dto.EmployeeRequest;
import com.muslimdev.attendance.dto.EmployeeResponse;
import com.muslimdev.attendance.entity.Employee;
import com.muslimdev.attendance.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public ApiResponse<EmployeeResponse> create(@RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.create(request);
        return ApiResponse.<EmployeeResponse>builder().data(response).build();
    }
}
