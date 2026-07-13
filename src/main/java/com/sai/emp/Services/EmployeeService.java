package com.sai.emp.Services;

import com.sai.emp.entities.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    List<Employee>getEmployeesByJob(Integer job_id);

    List<Employee>getEmployeesByDepartment(Integer dept_id);

    List<Employee>searchEmployees(String name);

    List<Employee>getEmployeesBySalaryInRange(BigDecimal min,BigDecimal max);

    List<Employee>getEmployeesByExperience(int years);

    Employee updateSalary(Integer emp_id,BigDecimal salary);

}
