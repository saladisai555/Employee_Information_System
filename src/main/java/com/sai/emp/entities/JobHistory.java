package com.sai.emp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "job_history")
public class JobHistory {

    @EmbeddedId
    private JobHistoryId id;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @MapsId("empId")
    @JoinColumn(name = "emp_id")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    @JsonIgnore
    private Job job;

    public JobHistory() {
    }

    public JobHistory(JobHistoryId id, LocalDate endDate, Employee employee, Job job) {
        this.id = id;
        this.endDate = endDate;
        this.employee = employee;
        this.job = job;
    }

    public JobHistory(JobHistoryId id, LocalDate endDate) {
        this.id = id;
        this.endDate = endDate;
    }

    public JobHistoryId getId() {
        return id;
    }

    public void setId(JobHistoryId id) {
        this.id = id;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistory that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "JobHistory{" +
                "id=" + id +
                ", endDate=" + endDate +
                '}';
    }
}