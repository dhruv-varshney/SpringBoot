package com.springpraticecomponentinjection.componentInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

        private final CricketCoach Ccoach;
        private final BadmintonCoach Bcoach;

        public DemoController(@Lazy CricketCoach Ccoach, BadmintonCoach Bcoach) {
            this.Ccoach = Ccoach;
            this.Bcoach = Bcoach;
        }
        @GetMapping("/workoutCricket")
        public String getDailyWorkoutCricket() {
            return Ccoach.getDailyWorkout();
        }

        @GetMapping("/workoutBadminton")
        public String getDailyWorkoutBadminton() {
            return Bcoach.getDailyWorkout();
        }
}
