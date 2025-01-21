package com.gala.standardization.platform;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatformApplication  {

	
	public static void main(String[] args) {
		try {
			SpringApplication.run(PlatformApplication.class, args);
	
		} catch (Exception e) {
			System.err.println("Failed to start application: " + e.getMessage());
			// Add proper logging here
			
		}
	}


}
