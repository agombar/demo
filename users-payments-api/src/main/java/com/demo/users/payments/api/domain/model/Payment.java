package com.demo.users.payments.api.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Payment {

	private UUID id;
	private BigDecimal amount;
	private LocalDateTime paymentDate;
	private User user;

}
