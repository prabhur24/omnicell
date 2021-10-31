package com.omnicell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.omnicell")

public class OmnicellApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmnicellApplication.class, args);
	}

}
