package com.devapp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.devapp")
public class SpringRestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulServiceApplication.class, args);
	}

}
