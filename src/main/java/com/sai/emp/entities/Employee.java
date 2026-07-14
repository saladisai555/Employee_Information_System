package com.sai.emp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name="emp_id")
    private Integer empId;
    @Column(name="emp_name")
    private String empName;

    @Column(name="salary",precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name="doj")
    private LocalDate date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="dept_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<JobHistory>jobHistories;
    public Employee(){

    }
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }
    public Employee(Integer empId,
                    String empName,
                    BigDecimal salary,
                    LocalDate date,
                    Job job,
                    Department department,
                    List<JobHistory> jobHistories) {

        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.date = date;
        this.job = job;
        this.department = department;
        this.jobHistories = jobHistories;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(empId, employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + empId +
                ", emp_name='" + empName + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                ", job=" + job +
                '}';
    }
}
