package com.springpraticecomponentinjection.componentInjection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    private final BeanService beanService;


    public AppRunner (BeanService beanService) {
        this.beanService = beanService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting application...");
        beanService.execute();
    }
}
