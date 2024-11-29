package com.springpraticecomponentinjection.componentInjection;

import com.springpraticecomponentinjection.common.BadmintonCoach;
import com.springpraticecomponentinjection.common.CricketCoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

        private final CricketCoach Ccoach;
        private final BadmintonCoach Bcoach;

        public DemoController(@Qualifier("cricketCoach") CricketCoach Ccoach, @Qualifier("badmintonCoach") BadmintonCoach Bcoach) {
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
