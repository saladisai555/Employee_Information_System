package com.sai.emp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class JobHistoryId implements Serializable {

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "start_date")
    private LocalDate startDate;

    public JobHistoryId() {
    }

    public JobHistoryId(Integer empId, Integer jobId, LocalDate startDate) {
        this.empId = empId;
        this.jobId = jobId;
        this.startDate = startDate;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistoryId that)) return false;
        return Objects.equals(empId, that.empId)
                && Objects.equals(jobId, that.jobId)
                && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, jobId, startDate);
    }

    @Override
    public String toString() {
        return "JobHistoryId{" +
                "empId=" + empId +
                ", jobId=" + jobId +
                ", startDate=" + startDate +
                '}';
    }
}