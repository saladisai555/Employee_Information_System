package com.sai.emp.repositories;

import com.sai.emp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
            List<Employee> findByJobJob_id(Integer job_id);

            List<Employee> findByDepartmentDept_id(Integer dept_id);

            List<Employee> findByEmp_nameContainingIgnoreCase(String name);

            List<Employee> findBySalaryBetween(BigDecimal min,BigDecimal max);

            List<Employee> findByDateBefore(LocalDate date);


}
