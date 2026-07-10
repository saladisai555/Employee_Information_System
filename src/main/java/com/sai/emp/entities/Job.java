package com.sai.emp.entities;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="job")
public class Job {
      @Id
      @Column(name="job_id")
      private Integer job_id;
      @Column(name="title")
      private String title;
      @OneToMany(mappedBy = "job")
      private List<Employee> employees;
      
    public Job(){

    }

    public Job(int job_id, String title) {
        this.job_id = job_id;
        this.title = title;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(job_id, job.job_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id);
    }
}
