package com.sai.emp.entities;
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
    List<Employee> employees;
    @OneToOne
    @JoinColumn(name = "emp_id_hod")
    private Employee hod;

    public Integer getDept_id() {
        return deptId;
    }

    public void setDept_id(Integer dept_id) {
        this.deptId = dept_id;
    }

    public String getDept_name() {
        return deptName;
    }

    public void setDept_name(String dept_name) {
        this.deptName = dept_name;
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
