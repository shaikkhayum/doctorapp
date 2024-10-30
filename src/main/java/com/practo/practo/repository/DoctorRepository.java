package com.practo.practo.repository;

import com.practo.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("SELECT d FROM Doctor d WHERE " +
            "(:name IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))) OR " +
            "(:specialization IS NULL OR LOWER(d.specializations) LIKE LOWER(CONCAT('%', :specialization, '%')))")
    List<Doctor> findByNameOrSpecialization(
            @Param("name") String name,
            @Param("specialization") String specialization);
}
