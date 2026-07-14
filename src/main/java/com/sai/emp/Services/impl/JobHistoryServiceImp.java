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
public class JobHistoryServiceImp implements JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;
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
    public List<JobHistory> getJobHistory(Integer empId) {

        return jobHistoryRepository.findByEmployeeEmpId(empId);
    }

    @Override
    public JobHistory addJobHistory(JobHistoryRequestDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmpId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobHistoryId id = new JobHistoryId(
                dto.getEmpId(),
                dto.getJobId(),
                dto.getStartDate()
        );

        JobHistory history=new JobHistory();
        history.setId(id);
        history.setJob(job);
        history.setEmployee(employee);
        history.setEndDate(dto.getEndDate());

        return jobHistoryRepository.save(history);

    }

}
