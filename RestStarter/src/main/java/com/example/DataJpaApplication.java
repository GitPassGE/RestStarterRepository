package com.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaApplication {

	// this is a rest with database example

	@Bean
	InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.save(new Car("Honda", "Civic", 1997));
			repository.save(new Car("Honda", "Accord", 2003));
			repository.save(new Car("Ford", "Escort", 1985));

		};
	}

	// branch 1 comment
	// actual branch 1.1 comment
	// actual branch 2 comment
	@Bean
	CommandLineRunner exampleQuery(CarRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA").forEach(System.err::println);

	}

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}
}