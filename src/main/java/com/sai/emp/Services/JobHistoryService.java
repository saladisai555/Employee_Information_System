package com.sai.emp.Services;

import com.sai.emp.dto.JobHistoryRequestDto;
import com.sai.emp.entities.Employee;
import com.sai.emp.entities.JobHistory;

import java.util.List;

public interface JobHistoryService {
    List<JobHistory>getJobHistory(Integer empId);

    JobHistory addJobHistory(JobHistoryRequestDto dto);
}
