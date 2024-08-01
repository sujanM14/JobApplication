package com.example.JobApp.Review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReview(companyId),HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public  ResponseEntity<Review> getReviewById(@PathVariable Long reviewId,@PathVariable Long companyId) {
        Review review=reviewService.getReviewById(reviewId,companyId);
        if(review!=null)
        return new ResponseEntity<>(review,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review) {
        boolean addedReview=reviewService.addReview(companyId,review);  
        if(addedReview)      
        return new ResponseEntity<>("Review added syccessfully",HttpStatus.OK);
        return new ResponseEntity<>("Review not added ",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId,@PathVariable Long companyId){
        boolean isDeleted=reviewService.deleteReview(reviewId,companyId);
        if(isDeleted){
            return new ResponseEntity<>("Review deleted syccessfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@PathVariable Long companyId, @RequestBody Review updatedReview) {
        boolean isUpdated=reviewService.updateReview(reviewId,companyId,updatedReview);
        if(isUpdated){
            return new ResponseEntity<>("Review updates syccessfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
}
