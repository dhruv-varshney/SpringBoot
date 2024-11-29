package com.example.thymeleafdemo.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @GetMapping ("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloworld";
    }

    @RequestMapping("/submitForm")
    public String submitForm() {
        return "submitform";
    }

    @RequestMapping("/processForm")
    public String processForm(Model theModel, @RequestParam("studentName") String studentName) {
        theModel.addAttribute("studentname" , studentName );
        return "processform";
    }
}
