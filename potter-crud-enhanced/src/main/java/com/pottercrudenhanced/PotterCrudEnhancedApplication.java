package com.pottercrudenhanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PotterCrudEnhancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotterCrudEnhancedApplication.class, args);
	}

}
