package com.sai.emp.Controllers;

import com.sai.emp.Services.EmployeeService;
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

    @GetMapping("/jobs/{job_id}")
    public List<Employee>getEmployeeByJob(@PathVariable Integer job_id){
        return employeeService.getEmployeesByJob(job_id);
    }

    @GetMapping("/department/{dept_id}")
    public List<Employee>getEmployeeByDepartment(@PathVariable Integer dept_id){
        return employeeService.getEmployeesByDepartment(dept_id);
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

    @PutMapping("/{emp_id}/salary")
    public Employee updateSalary(@PathVariable Integer emp_id,@RequestParam BigDecimal salary){
        return employeeService.updateSalary(emp_id,salary);
    }
}
