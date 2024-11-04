package com.demo.payments.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.demo.payments.processor.application",
	"com.demo.payments.processor.domain",
	"com.demo.payments.processor.infrastructure"
})
public class PaymentsProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsProcessorApplication.class, args);
	}

}
