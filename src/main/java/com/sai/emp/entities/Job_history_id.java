package com.sai.emp.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class Job_history_id implements Serializable {
    private Integer emp_id;
    private Integer job_id;
    private LocalDate start_date;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Job_history_id that)) return false;
        return Objects.equals(emp_id, that.emp_id) && Objects.equals(job_id, that.job_id) && Objects.equals(start_date, that.start_date);
    }
   public Job_history_id(){

   }
    public Job_history_id(Integer emp_id, Integer job_id, LocalDate start_date) {
        this.emp_id = emp_id;
        this.job_id = job_id;
        this.start_date = start_date;
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

    @Override
    public int hashCode() {
        return Objects.hash(emp_id, job_id, start_date);
    }

    @Override
    public String toString() {
        return "Job_history_id{" +
                "emp_id=" + emp_id +
                ", job_id=" + job_id +
                ", start_date=" + start_date +
                '}';
    }
}
