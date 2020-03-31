package com.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.angular.*"})@EnableJpaRepositories()
public class FlightApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FlightApplication.class, args);
	}
}

