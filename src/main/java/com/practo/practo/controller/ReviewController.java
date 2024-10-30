package com.practo.practo.controller;


import com.practo.practo.entity.Doctor;
import com.practo.practo.entity.Review;
import com.practo.practo.payload.DoctorDto;
import com.practo.practo.repository.DoctorRepository;
import com.practo.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.createReview(review);

        if (savedReview != null) {
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewByDoctorId(@PathVariable long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviews = reviewService.getReviewByDoctorId(doctorId);

        double totalRating =0;
        for (Review review:reviews){
            totalRating += review.getRating();
        }

        double averageRating = totalRating / reviews.size();
        double ratingPercentage = (averageRating / 5.0) * 100.0;


        DoctorDto dto = new DoctorDto();
        dto.setDoctor(doctor);
        dto.setReviews(reviews);
        dto.setRatingPercentage(ratingPercentage);

        return new ResponseEntity<>(dto,HttpStatus.OK);

    }




}
