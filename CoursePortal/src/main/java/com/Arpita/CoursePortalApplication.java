package com.Arpita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoursePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursePortalApplication.class, args);
	}

}
