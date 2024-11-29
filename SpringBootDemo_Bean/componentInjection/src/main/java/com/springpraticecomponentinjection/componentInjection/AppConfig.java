package com.springpraticecomponentinjection.componentInjection;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CricketCoach cricketCoach() {
        return new CricketCoach();
    }

    @Bean
    public BadmintonCoach badmintonCoach() {
        return new BadmintonCoach();
    }
}
