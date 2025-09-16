package com.muslimdev.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muslimdev.attendance.dto.DepartmentRequest;
import com.muslimdev.attendance.dto.DepartmentResponse;
import com.muslimdev.attendance.entity.Department;
import com.muslimdev.attendance.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public DepartmentResponse create(DepartmentRequest request) {

        Department department = new Department();
        department.setName(request.getName());

        departmentRepository.save(department);

        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }
}
