package com.sai.emp.repositories;

import com.sai.emp.entities.Employee;
import com.sai.emp.entities.JobHistory;
import com.sai.emp.entities.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {

    List<JobHistory>findByEmployeeEmp_id(Integer emp_id);
}
