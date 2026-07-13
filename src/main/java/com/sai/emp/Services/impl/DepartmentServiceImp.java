package com.sai.emp.Services.impl;

import com.sai.emp.Services.DepartmentService;
import com.sai.emp.entities.Department;
import com.sai.emp.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    DepartmentServiceImp(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
