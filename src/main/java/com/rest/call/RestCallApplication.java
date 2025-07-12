package com.rest.call;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rest.call", "com.example"})
public class RestCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCallApplication.class, args);
	}

}
