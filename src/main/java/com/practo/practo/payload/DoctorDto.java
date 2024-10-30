package com.practo.practo.payload;

import com.practo.practo.entity.Doctor;
import com.practo.practo.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Doctor doctor;
    private List<Review> reviews;
    private double ratingPercentage;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRatingPercentage(double ratingPercentage) {
        this.ratingPercentage = ratingPercentage;
    }
}




