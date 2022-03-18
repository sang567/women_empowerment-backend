package com.lti.project.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(SpringProjectApplication.class, args);
	}
}
