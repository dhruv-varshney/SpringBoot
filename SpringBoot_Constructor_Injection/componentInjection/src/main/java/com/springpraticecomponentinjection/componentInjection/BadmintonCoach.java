package com.springpraticecomponentinjection.componentInjection;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice badminton for 30 minutes today";
    }
}
