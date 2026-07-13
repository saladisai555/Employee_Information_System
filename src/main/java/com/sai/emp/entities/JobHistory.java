package com.sai.emp.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="job_history")
public class JobHistory {
    @EmbeddedId
    private JobHistoryId id;
    @Column(name="end_date")
    private LocalDate endDate;
    @ManyToOne
    @MapsId("emp_id")
    @JoinColumn(name="emp_id")
    private Employee employee;

    @ManyToOne
    @MapsId("job_id")
    @JoinColumn(name="job_id")
    private Job job;
    public JobHistory(){

    }

    public JobHistory(JobHistoryId id, LocalDate endDate, Employee employee, Job job) {
        this.id = id;
        this.endDate = endDate;
        this.employee = employee;
        this.job = job;
    }

    public JobHistory(JobHistoryId id, LocalDate end_date) {
        this.id = id;
        this.endDate = end_date;
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

    public JobHistoryId getId() {
        return id;
    }

    public void setId(JobHistoryId id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Job_history{" +
                "id=" + id +
                ", end_date=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof JobHistory that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
