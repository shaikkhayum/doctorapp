package com.practo.practo.repository;

import com.practo.practo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Booking, Long> {

}
