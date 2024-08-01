package com.example.JobApp.Job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.JobApp.Job.Job;
import com.example.JobApp.Job.JobRepository;
import com.example.JobApp.Job.JobService;

@Service
public class jobServiceImplementation implements JobService {
    JobRepository jobRepository;
    public jobServiceImplementation(JobRepository jobRepository){
       this.jobRepository=jobRepository;
    }
    private long nextId=1L;

    @Override
    public List<Job> findAll() {
       return jobRepository.findAll();
    }



    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
    }



    @Override
    public Job getJobbyId(Long id) {
        return jobRepository.findById(id).orElse(null);
    }



    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id); 
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }



    @Override
    public boolean updateJobById(Long id,Job updatedJob) {
       Optional<Job> optionalJob=jobRepository.findById(id); 
            if(optionalJob.isPresent()){
                Job jb=optionalJob.get();
               jb.setDescription(updatedJob.getDescription());
               jb.setLocation(updatedJob.getLocation());
               jb.setMaxSalaray(updatedJob.getMaxSalaray());
               jb.setMinSalary(updatedJob.getMinSalary());
               jb.setTitle(updatedJob.getTitle());
               jobRepository.save(jb);
               return true;

            }
        
        return false;
    }
    
}
