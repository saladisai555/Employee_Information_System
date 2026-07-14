package com.sai.emp.Controllers;

import com.sai.emp.Services.JobHistoryService;
import com.sai.emp.Services.impl.JobHistoryServiceImp;
import com.sai.emp.dto.JobHistoryRequestDto;
import com.sai.emp.entities.JobHistory;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobHistory")
public class JobHistoryController {
    private final JobHistoryService jobHistoryService;
    JobHistoryController(JobHistoryService jobHistoryService){
        this.jobHistoryService=jobHistoryService;
    }

    @GetMapping("/{emp_id}")
    public List<JobHistory>getJobHistory(@PathVariable Integer emp_id){
        return jobHistoryService.getJobHistory(emp_id);
    }

    @PostMapping
    public JobHistory addJobHistory(@RequestBody JobHistoryRequestDto dto){
        return jobHistoryService.addJobHistory(dto);
    }
}
