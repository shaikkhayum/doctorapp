package com.practo.practo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TimeSlotConfiguration {

    @Bean
    public TimeSlotManager timeSlotManager(){
        List<String> avaliableTimeSlots = new ArrayList<>();
        avaliableTimeSlots.add("10:15 AM");
        avaliableTimeSlots.add("11:15 AM");
        avaliableTimeSlots.add("12:15 PM");

        return new TimeSlotManager(avaliableTimeSlots);

    }


}
