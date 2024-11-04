package com.demo.users.payments.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.demo.users.payments.sink.application",
	"com.demo.users.payments.sink.domain",
	"com.demo.users.payments.sink.infrastructure"
})
public class UsersPaymentsSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersPaymentsSinkApplication.class, args);
	}

}
