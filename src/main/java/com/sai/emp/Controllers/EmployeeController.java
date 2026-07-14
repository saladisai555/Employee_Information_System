package com.sai.emp.Controllers;

import com.sai.emp.Services.EmployeeService;
import com.sai.emp.dto.SalaryUpdateRequestDto;
import com.sai.emp.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/jobs/{jobId}")
    public List<Employee>getEmployeeByJob(@PathVariable Integer jobId){
        return employeeService.getEmployeesByJob(jobId);
    }

    @GetMapping("/department/{deptId}")
    public List<Employee>getEmployeeByDepartment(@PathVariable Integer deptId){
        return employeeService.getEmployeesByDepartment(deptId);
    }

    @GetMapping("/search")
    public List<Employee>searchEmployees(@RequestParam String name){
        return employeeService.searchEmployees(name);
    }

    @GetMapping("/salary")
    public List<Employee>getEmployeesBySalaryInRange(@RequestParam BigDecimal min,BigDecimal max){
        return employeeService.getEmployeesBySalaryInRange(min,max);
    }

    @GetMapping("/experience")
    public List<Employee>getEmployeesByExperience(@RequestParam int years){
        return employeeService.getEmployeesByExperience(years);
    }

    @PutMapping("/{empId}/salary")
    public Employee updateSalary(@PathVariable Integer empId, @RequestBody SalaryUpdateRequestDto dto){
        return employeeService.updateSalary(empId,dto);
    }
}
