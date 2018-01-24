package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Entry point for Spring Boot
 *
 */
@SpringBootApplication // Required by spring to pinpoint app entry point
public class CourseAppDemo {

	public static void main(String[] args) { //
		SpringApplication.run(CourseAppDemo.class, args); // Single line which will inject our entry point to the spring container
	}

}
