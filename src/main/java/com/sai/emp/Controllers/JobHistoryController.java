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
    public JobHistoryController(JobHistoryService jobHistoryService){
        this.jobHistoryService=jobHistoryService;
    }

    @GetMapping("/{empId}")
    public List<JobHistory>getJobHistory(@PathVariable Integer empId){
        return jobHistoryService.getJobHistory(empId);
    }

    @PostMapping
    public JobHistory addJobHistory(@RequestBody JobHistoryRequestDto dto){
        return jobHistoryService.addJobHistory(dto);
    }
}
