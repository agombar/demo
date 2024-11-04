package com.demo.users.payments.api.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Users payments API")
				.version("1.0.0")
				.description("API documentation for users payments API microservice built with Spring Boot and OpenAPI."));
	}

}
