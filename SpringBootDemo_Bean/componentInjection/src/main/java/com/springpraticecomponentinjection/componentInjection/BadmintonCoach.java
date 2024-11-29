package com.springpraticecomponentinjection.componentInjection;

import org.springframework.context.annotation.Bean;

public class BadmintonCoach {
    public BadmintonCoach() {
        System.out.println("EagerBean initialized");
    }

    public void doSomething() {
        System.out.println("EagerBean is doing something!");
    }

    @Bean
    public String getDailyWorkout() {
        System.out.println("Practice backhand for 30 minutes");
        return "Practice backhand for 30 minutes";
    }
}

