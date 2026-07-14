package com.sai.emp.dto;

import java.time.LocalDate;

public class JobHistoryRequestDto {

    private Integer empId;

    private Integer jobId;

    private LocalDate startDate;

    private LocalDate endDate;

    public JobHistoryRequestDto() {
    }

    public JobHistoryRequestDto(Integer empId,
                                Integer jobId,
                                LocalDate startDate,
                                LocalDate endDate) {
        this.empId = empId;
        this.jobId = jobId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
