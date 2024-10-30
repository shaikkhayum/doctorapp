package com.practo.practo.service;

import com.practo.practo.entity.Doctor;
import com.practo.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Method to add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> searchByNameOrSpecialization(String name, String specialization) {
        return doctorRepository.findByNameOrSpecialization(name, specialization);
    }
    // Method to get all doctors
    //public List<Doctor> getAllDoctors() {
    //  return doctorRepository.findAll();
    //}

    // Method to get a doctor by ID
    // public Doctor getDoctorById(Long id) {
    //   return doctorRepository.findById(id)
    //         .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
    //}

    // Other service methods can be added here (update, delete, etc.)
}
