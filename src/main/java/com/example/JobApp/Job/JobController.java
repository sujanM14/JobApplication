package com.example.JobApp.Job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/jobs")
public class JobController {
    
    private JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return  ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Job> getJobById(@PathVariable Long id){
        Job job =jobService.getJobbyId(id);
        if(job !=null)
        return new ResponseEntity<>(job,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobbyId(@PathVariable Long id){
        boolean deleted=jobService.deleteJob(id);
        if(!deleted){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }else{
            jobService.deleteJob(id);
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated=jobService.updateJobById(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("Job has been updated",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
