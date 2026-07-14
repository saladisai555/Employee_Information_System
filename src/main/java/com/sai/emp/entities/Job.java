package com.sai.emp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="job")
public class Job {
      @Id
      @Column(name="job_id")
      private Integer jobId;
      @Column(name="title")
      private String title;
      @OneToMany(mappedBy = "job")
      @JsonIgnore
      private List<Employee> employees;
      @OneToMany(mappedBy="job")
      @JsonIgnore
      private List<JobHistory>jobHistories;
    public Job(){

    }

    public Job(Integer job_id, String title, List<Employee> employees, List<JobHistory> jobHistories) {
        this.jobId = job_id;
        this.title = title;
        this.employees = employees;
        this.jobHistories = jobHistories;
    }

    public Job(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    public List<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    public Job(int job_id, String title) {
        this.jobId = job_id;
        this.title = title;
    }

    public Integer getJob_id() {
        return jobId;
    }

    public void setJob_id(Integer job_id) {
        this.jobId = job_id;
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
                "job_id=" + jobId +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(jobId, job.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }
}
