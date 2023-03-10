package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SprimgMongodbApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SprimgMongodbApplication.class, args);
	}

}
