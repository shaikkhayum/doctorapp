package com.practo.practo.service;

import com.practo.practo.entity.Doctor;
import com.practo.practo.entity.Patient;
import com.practo.practo.entity.Review;
import com.practo.practo.repository.DoctorRepository;
import com.practo.practo.repository.PatientRepository;
import com.practo.practo.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ReviewRepository reviewRepo;


    @Transactional
    public Review createReview(Review review) {
        // Fetch the Doctor and Patient by their IDs to ensure they exist
        Doctor doctor = doctorRepo.findById(review.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepo.findById(review.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Save and return the review if both doctor and patient exist
        return reviewRepo.save(review);
    }

    public List<Review> getReviewByDoctorId(long doctorId){

        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
        return reviews;


    }





}
