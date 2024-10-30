package com.practo.practo.controller;


import com.practo.practo.payload.BookingDto;
import com.practo.practo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookAnAppoinentement(@RequestBody BookingDto bookingDto){
        bookingService.bookAnAppointment(bookingDto);
        return new ResponseEntity<>("Booking is confirmed", HttpStatus.CREATED);
    }

}
