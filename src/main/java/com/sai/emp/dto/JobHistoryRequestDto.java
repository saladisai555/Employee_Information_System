package com.sai.emp.dto;

import java.time.LocalDate;

public class JobHistoryRequestDto {

        private Integer emp_id;

        private Integer job_id;

        private LocalDate start_date;

        private LocalDate end_date;

        public JobHistoryRequestDto() {
        }

        public JobHistoryRequestDto(Integer emp_id,
                                    Integer job_id,
                                    LocalDate start_date,
                                    LocalDate end_date) {

            this.emp_id = emp_id;
            this.job_id = job_id;
            this.start_date = start_date;
            this.end_date = end_date;
        }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    }

