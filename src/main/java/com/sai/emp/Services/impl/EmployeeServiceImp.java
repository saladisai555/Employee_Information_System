package com.sai.emp.Services.impl;

import com.sai.emp.Services.EmployeeService;
import com.sai.emp.dto.SalaryUpdateRequestDto;
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

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeesByJob(Integer jobId) {
        return employeeRepository.findByJobJobId(jobId);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer deptId) {
        return employeeRepository.findByDepartmentDeptId(deptId);
    }

    @Override
    public List<Employee> searchEmployees(String name) {
        return employeeRepository.findByEmpNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeesBySalaryInRange(BigDecimal min, BigDecimal max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    @Override
    public List<Employee> getEmployeesByExperience(int years) {

        LocalDate date = LocalDate.now().minusYears(years);

        return employeeRepository.findByDateBefore(date);
    }

    @Override
    public Employee updateSalary(Integer empId, SalaryUpdateRequestDto dto) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setSalary(dto.getSalary());

        return employeeRepository.save(employee);
    }
}
