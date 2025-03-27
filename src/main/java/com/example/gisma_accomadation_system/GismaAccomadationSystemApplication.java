package com.example.gisma_accomadation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class GismaAccomadationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GismaAccomadationSystemApplication.class, args);
	}

}
