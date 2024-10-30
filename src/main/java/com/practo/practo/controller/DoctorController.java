package com.practo.practo.controller;
import com.practo.practo.entity.Doctor;
import com.practo.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    private String search;

    // Endpoint to add a new doctor
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public List<Doctor> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization) {

        return doctorService.searchByNameOrSpecialization(name, specialization);
    }

    // Endpoint to get all doctors
    //@GetMapping
   // public ResponseEntity<List<Doctor>> getAllDoctors() {
      //  List<Doctor> doctors = doctorService.getAllDoctors();
      //  return new ResponseEntity<>(doctors, HttpStatus.OK);
   // }

    // Endpoint to get a doctor by ID
   //@GetMapping("/{id}")
    //public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
      //  Doctor doctor = doctorService.getDoctorById(id);
        //return new ResponseEntity<>(doctor, HttpStatus.OK);
    //}

    // Additional endpoints (update, delete, etc.) can be added here
//}

}