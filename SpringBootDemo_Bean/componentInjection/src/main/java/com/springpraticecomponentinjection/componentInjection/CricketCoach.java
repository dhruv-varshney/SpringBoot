package com.springpraticecomponentinjection.componentInjection;


public class CricketCoach  {
    public CricketCoach() {
        System.out.println("LazyBean initialized");
    }

    public void doSomething() {
        System.out.println("LazyBean is doing something!");
    }

    public String getDailyWorkout() {
        System.out.println("Practice fast bowling for 15 minutes");
        return "Practice fast bowling for 15 minutes";
    }
}

