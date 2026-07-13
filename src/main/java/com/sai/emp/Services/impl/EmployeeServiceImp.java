package com.sai.emp.Services.impl;

import com.sai.emp.Services.EmployeeService;
import com.sai.emp.entities.Employee;
import com.sai.emp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> getEmployeesByJob(Integer job_id) {
        return employeeRepository.findByJobJob_id(job_id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer dept_id) {
        return employeeRepository.findByDepartmentDept_id(dept_id);
    }

    @Override
    public List<Employee> searchEmployees(String name) {
        return employeeRepository.findByEmp_nameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeesBySalaryInRange(BigDecimal min, BigDecimal max) {
        return employeeRepository.findBySalaryBetween(min,max);
    }

    @Override
    public List<Employee> getEmployeesByExperience(int years) {
        LocalDate date=LocalDate.now().minusYears(years);
        return employeeRepository.findByDateBefore(date);
    }

    @Override
    public Employee updateSalary(Integer emp_id, BigDecimal salary) {
        Employee employee=employeeRepository.findById(emp_id).orElseThrow(
                ()->new RuntimeException("Employee not found")
        );
        employee.setSalary(salary);
        return employeeRepository.save(employee);
    }
}
