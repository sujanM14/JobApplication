package com.example.JobApp.Company;

import java.util.List;
import com.example.JobApp.Job.Job;
import com.example.JobApp.Review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    
    @OneToMany(mappedBy ="company")
    private List<Job> jobs;
    
    @OneToMany
    private List<Review> reviews;
    public Company(Long id, String name, String description, List<Job> jobs,List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
        this.reviews=reviews;
        
    }
   
    // Default Constructor
    public Company() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public List<Review> getReviews() {
        return reviews;
    }

    // Setters
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}
