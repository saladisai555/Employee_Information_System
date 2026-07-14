package com.sai.emp.Controllers;
import com.sai.emp.entities.Job;
import com.sai.emp.repositories.JobRepository;
import com.sai.emp.Services.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;
    JobController(JobService jobService){
        this.jobService=jobService;
    }

    @GetMapping("/jobs")
    public List<Job>getAllJobs(){
        return jobService.getAllJobs();
    }
}
