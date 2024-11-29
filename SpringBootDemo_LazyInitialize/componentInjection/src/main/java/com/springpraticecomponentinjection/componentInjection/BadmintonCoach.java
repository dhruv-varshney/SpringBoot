package com.springpraticecomponentinjection.componentInjection;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach {
    public BadmintonCoach() {
        System.out.println("EagerBean initialized");
    }

    public void doSomething() {
        System.out.println("EagerBean is doing something!");
    }

    public String getDailyWorkout() {
        System.out.println("Practice backhand for 30 minutes");
        return "Practice backhand for 30 minutes";
    }
}

