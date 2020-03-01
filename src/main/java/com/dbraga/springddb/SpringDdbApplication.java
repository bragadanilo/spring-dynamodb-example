package com.dbraga.springddb;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.dbraga.springddb.repository")
public class SpringDdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDdbApplication.class, args);
	}

}
