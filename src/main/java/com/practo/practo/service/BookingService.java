package com.practo.practo.service;


import com.practo.practo.config.TimeSlotManager;
import com.practo.practo.entity.Booking;
import com.practo.practo.payload.BookingDto;
import com.practo.practo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private TimeSlotManager timeSlotManager;

    public void bookAnAppointment(BookingDto dto){
        List<String> availableTimeSlots = new ArrayList<>();
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");

        Booking booking = new Booking();

        for (String slots:availableTimeSlots){
            if (slots.equals(dto.getBookingTime())){
                booking.setBookingTime(dto.getBookingTime());
                availableTimeSlots.remove(slots);

            }
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(()-> {

                    System.out.println("Executing code every 24 hours...");
                    availableTimeSlots.add("10:15 AM");
                    availableTimeSlots.add("11:15 AM");
                    availableTimeSlots.add("12:15 PM");

                },0,24, TimeUnit.HOURS);

        booking.setDoctorId(dto.getDoctorId());
        booking.setPatientId(dto.getPatientId());

        if (booking.getBookingTime()!=null){
            bookRepo.save(booking);
        }else{
            System.out.println("Time Slot Not Avaliable");
        }
    }

}
