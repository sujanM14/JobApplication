package com.example.JobApp.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long>{

    List<Review> findBycompanyId(Long companyId);
    
}
