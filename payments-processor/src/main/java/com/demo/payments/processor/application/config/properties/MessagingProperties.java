package com.demo.payments.processor.application.config.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messaging")
@Data
@Accessors(chain = true)
public class MessagingProperties {

	private MessagingRouting paymentExternalCreated;
	private MessagingRouting paymentCreated;


}