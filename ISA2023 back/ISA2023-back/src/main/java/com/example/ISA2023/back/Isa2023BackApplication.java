package com.example.ISA2023.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class Isa2023BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Isa2023BackApplication.class, args);
	}

}
