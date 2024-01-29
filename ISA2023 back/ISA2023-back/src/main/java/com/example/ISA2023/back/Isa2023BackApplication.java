package com.example.ISA2023.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class Isa2023BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Isa2023BackApplication.class, args);
	}

}
