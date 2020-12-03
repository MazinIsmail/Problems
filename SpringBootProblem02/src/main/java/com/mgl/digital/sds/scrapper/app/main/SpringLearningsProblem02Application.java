package com.mgl.digital.sds.scrapper.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.mgl.digital.sds.scrapper.app*")
public class SpringLearningsProblem02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningsProblem02Application.class, args);
	}

}