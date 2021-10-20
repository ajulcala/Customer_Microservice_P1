package com.microservice.customer;

import com.github.mongobee.Mongobee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CustomerMicroserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroserviceApplication.class, args);
	}

}
