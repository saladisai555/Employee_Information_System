package com.sai.emp.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="job_history")
public class JobHistory {
    @EmbeddedId
    private Job_history_id id;
    private LocalDate end_date;
    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
    public JobHistory(){

    }
    public JobHistory(Job_history_id id, LocalDate end_date) {
        this.id = id;
        this.end_date = end_date;
    }

    public Job_history_id getId() {
        return id;
    }

    public void setId(Job_history_id id) {
        this.id = id;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Job_history{" +
                "id=" + id +
                ", end_date=" + end_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof JobHistory that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(end_date, that.end_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, end_date);
    }
}
