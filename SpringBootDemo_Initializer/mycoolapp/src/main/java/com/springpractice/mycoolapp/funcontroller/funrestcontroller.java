package com.springpractice.mycoolapp.funcontroller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/dhruv1")
    public String sayHelloDhruv(){
        return "Hello Dhruv!";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+", Team: "+teamName;
    }
    @GetMapping("${coach.name}")
    public String getCoachName(){
        return coachName;
    }

}
