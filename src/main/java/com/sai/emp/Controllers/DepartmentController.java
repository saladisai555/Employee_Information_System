package com.sai.emp.Controllers;

import com.sai.emp.Services.DepartmentService;
import com.sai.emp.entities.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;
    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @GetMapping("/departments")
    public List<Department>getAllDepartments(){
        return departmentService.getAllDepartments();
    }
}
