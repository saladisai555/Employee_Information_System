package com.sai.emp.Services.impl;

import com.sai.emp.Services.JobService;
import com.sai.emp.entities.Job;
import com.sai.emp.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImp implements JobService {
    private final JobRepository jobRepository;
    JobServiceImp(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

}
