package com.springpractice.mycoolapp.funcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/dhruv1")
    public String sayHelloDhruv(){
        return "Hello Dhruv!";
    }
    @GetMapping("/testdev")
    public String testdev(){
        return "Hello Dev tools";
    }

}
