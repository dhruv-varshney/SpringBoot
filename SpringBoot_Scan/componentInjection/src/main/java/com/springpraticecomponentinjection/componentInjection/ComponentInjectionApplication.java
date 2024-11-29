package com.springpraticecomponentinjection.componentInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
		scanBasePackages = {"com.springpraticecomponentinjection.common"}
)

public class ComponentInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentInjectionApplication.class, args);
	}

}
