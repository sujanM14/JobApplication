package com.example.JobApp.Review;

import java.util.List;

public interface ReviewService {
    Review getReviewById(Long reviewId,Long companyId);
    List<Review> getReview(Long companyId);
    boolean addReview(Long companyId,Review review);
    boolean updateReview(Long reviewId,Long companyId,Review updatedReview);
    boolean deleteReview(Long reviewId,Long companyId);
    
}
