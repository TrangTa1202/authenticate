package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		// System.setProperty("server.port", "8081");
		SpringApplication.run(HelloworldApplication.class, args);

	}
}