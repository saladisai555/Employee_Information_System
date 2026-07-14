package com.sai.emp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @Column(name="dept_id")
    private Integer deptId;
    @Column(name="dept_name")
    private String deptName;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    List<Employee> employees;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "emp_id_hod")
    private Employee hod;

    public Department(Integer deptId, String deptName, List<Employee> employees, Employee hod) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employees = employees;
        this.hod = hod;
    }
    public Department(){

    }
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getHod() {
        return hod;
    }

    public void setHod(Employee hod) {
        this.hod = hod;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + deptId +
                ", dept_name='" + deptName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Department that)) return false;
        return Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId);
    }
}
