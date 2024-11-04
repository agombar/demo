package com.demo.users.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.demo.users.processor.application",
	"com.demo.users.processor.domain",
	"com.demo.users.processor.infrastructure"
})
public class UsersProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersProcessorApplication.class, args);
	}

}
