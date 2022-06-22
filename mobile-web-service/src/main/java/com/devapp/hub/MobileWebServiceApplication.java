package com.devapp.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.devapp")
public class MobileWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileWebServiceApplication.class, args);
	}

}
