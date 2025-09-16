package com.muslimdev.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.attendance.dto.ApiResponse;
import com.muslimdev.attendance.dto.DepartmentRequest;
import com.muslimdev.attendance.dto.DepartmentResponse;
import com.muslimdev.attendance.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ApiResponse<DepartmentResponse> create(@RequestBody DepartmentRequest request) {
        DepartmentResponse response = departmentService.create(request);
        return ApiResponse.<DepartmentResponse>builder().data(response).build();
    }

}
