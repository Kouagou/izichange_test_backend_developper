package com.izichange.test_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IzichangeTestBackendDevelopperApplication {

	public static void main(String[] args) {
		SpringApplication.run(IzichangeTestBackendDevelopperApplication.class, args);
	}

}
