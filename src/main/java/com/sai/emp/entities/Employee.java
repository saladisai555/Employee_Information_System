package com.sai.emp.entities;
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
    private Integer emp_id;
    @Column(name="emp_name")
    private String emp_name;

    @Column(name="salary",precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name="doj")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    List<JobHistory>jobHistories;
    public Employee(){

    }
    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
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

    public Employee(Integer emp_id, String emp_name, BigDecimal salary, LocalDate date, Job job, Department department, List<JobHistory> jobHistories) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.salary = salary;
        this.date = date;
        this.job = job;
        this.department = department;
        this.jobHistories = jobHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(emp_id, employee.emp_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emp_id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                ", job=" + job +
                '}';
    }
}
