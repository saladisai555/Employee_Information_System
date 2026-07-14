package com.sai.emp.Services.impl;

import com.sai.emp.Services.JobHistoryService;
import com.sai.emp.dto.JobHistoryRequestDto;
import com.sai.emp.entities.Job;
import com.sai.emp.entities.JobHistory;
import com.sai.emp.entities.JobHistoryId;
import com.sai.emp.repositories.EmployeeRepository;
import com.sai.emp.repositories.JobHistoryRepository;
import com.sai.emp.repositories.JobRepository;
import org.springframework.stereotype.Service;
import com.sai.emp.entities.Employee;
import java.util.List;

@Service
public class JobHistoryServiceImp implements JobHistoryService {private final JobHistoryRepository jobHistoryRepository;
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    public JobHistoryServiceImp(JobHistoryRepository jobHistoryRepository,
                                EmployeeRepository employeeRepository,
                                JobRepository jobRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }
    @Override
    public List<JobHistory> getJobHistory(Integer emp_id) {

        return jobHistoryRepository.findByEmployeeEmp_id(emp_id);
    }

    @Override
    public JobHistory addJobHistory(JobHistoryRequestDto dto) {
      Employee employee= employeeRepository.findById(dto.getEmp_id())
                          .orElseThrow(() -> new RuntimeException("employee not found"));
      Job job=jobRepository.findById(dto.getJob_id())
                           .orElseThrow(()->new RuntimeException("job not found"));
        JobHistoryId id=new JobHistoryId(
                dto.getEmp_id(),
                dto.getJob_id(),
                dto.getStart_date()
        );
        JobHistory history=new JobHistory();
        history.setId(id);
        history.setEndDate(dto.getEnd_date());
        history.setJob(job);
        history.setEmployee(employee);

        return jobHistoryRepository.save(history);

    }

}
