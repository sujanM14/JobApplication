package com.example.JobApp.Review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.JobApp.Company.Company;
import com.example.JobApp.Company.CompanyService;
import com.example.JobApp.Review.Review;
import com.example.JobApp.Review.ReviewRepository;
import com.example.JobApp.Review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    private Long nextId=1L;
    public ReviewServiceImpl (ReviewRepository reviewRepository,CompanyService companyService){
        this.reviewRepository=reviewRepository;
        this.companyService=companyService;
    }
    @Override
    public Review getReviewById(Long reviewIid,Long comapanyId) {
        List<Review> reviews=reviewRepository.findBycompanyId(comapanyId);

        return reviews.stream().filter(review->review.getId().equals(reviewIid)).findFirst().orElse(null);
        
    }
    @Override
    public List<Review> getReview(Long companyId) {
        List<Review> reviews=reviewRepository.findBycompanyId(companyId);
        
       return reviews;
    }
    @Override
    public boolean addReview(Long companyId,Review review) {
        review.setId(nextId++);
        Company company=companyService.getComapanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
       

    }
    @Override
    public boolean updateReview(Long reviewId,Long companyId,Review updatedReview) {
       
        if(reviewRepository.findBycompanyId(companyId)!=null){
            updatedReview.setCompany(companyService.getComapanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteReview(Long reviewId,Long companyId) {
        if(companyService.getComapanyById(companyId)!=null  && reviewRepository.existsById(reviewId)){
            // as review is present in both company review and reviews too as it is bidirectional mapping
            Review review =reviewRepository.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompanyById(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        } else{
           return false;
        }
    }
}
