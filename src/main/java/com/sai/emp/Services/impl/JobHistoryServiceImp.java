package com.sai.emp.Services.impl;

import com.sai.emp.Services.JobHistoryService;
import com.sai.emp.entities.JobHistory;
import com.sai.emp.repositories.JobHistoryRepository;
import org.springframework.stereotype.Service;
import com.sai.emp.entities.Employee;
import java.util.List;

@Service
public class JobHistoryServiceImp implements JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;
    JobHistoryServiceImp(JobHistoryRepository jobHistoryRepository){
        this.jobHistoryRepository=jobHistoryRepository;
    }
    @Override
    public List<JobHistory> getJobHistory(Integer emp_id) {
        return jobHistoryRepository.findByEmployeeEmp_id(emp_id);
    }

    @Override
    public JobHistory addJobHistory(JobHistory jobHistory) {
          return jobHistoryRepository.save(jobHistory);
    }

}
