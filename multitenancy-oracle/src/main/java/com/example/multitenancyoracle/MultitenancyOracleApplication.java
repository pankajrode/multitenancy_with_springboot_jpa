package com.example.multitenancyoracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableJpaRepositories("com.example.multitenancyoracle.repository")
public class MultitenancyOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenancyOracleApplication.class, args);
	}

}
