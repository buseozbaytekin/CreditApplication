package com.springboot.creditApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CreditAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(CreditAppApplication.class, args);
	}

}
