package com.example.JobApp.Job;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
    
}
