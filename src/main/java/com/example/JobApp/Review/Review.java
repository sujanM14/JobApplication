package com.example.JobApp.Review;

import com.example.JobApp.Company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;
    public Review() {
    }

    // Parameterized constructor
    public Review(Long id, String title, String description, double rating,Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.company=company;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
