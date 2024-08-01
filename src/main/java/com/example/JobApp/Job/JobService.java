package com.example.JobApp.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobbyId(Long id);
    boolean deleteJob(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    
    

}
