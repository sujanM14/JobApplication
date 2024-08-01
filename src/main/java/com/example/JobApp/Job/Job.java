package com.example.JobApp.Job;


import com.example.JobApp.Company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

// it tell that this has to converted to entity
@Entity
// @Table(name="Job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalaray;
    private String location;

    @ManyToOne
    private Company company;
    // it is required when using with JPA so that it can intantiate entity
    public Job(){

    }
    public Job(Long id, String t, String desc, String minS, String maxS, String loc,Company company) {
        this.id = id;
        this.title = t;
        this.description = desc;
        this.maxSalaray = maxS;
        this.minSalary = minS;
        this.location = loc;
        this.company=company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompany(Company company){
        this.company=company;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalaray() {
        return maxSalaray;
    }

    public void setMaxSalaray(String maxSalaray) {
        this.maxSalaray = maxSalaray;
    }

    public String getLocation() {
        return location;
    }
    public Company getCompany() {
        return company;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
