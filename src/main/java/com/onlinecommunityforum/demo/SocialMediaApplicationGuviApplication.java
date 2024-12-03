package com.onlinecommunityforum.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.solution.controller", "com.solution.mobiquity.service"})
@SpringBootApplication
public class SocialMediaApplicationGuviApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplicationGuviApplication.class, args);
	}

}
