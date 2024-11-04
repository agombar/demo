package com.demo.users.payments.sink.application.listener.payment.dto.create;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class PaymentContentCreateMessage {

	private UUID id;
	private UUID userId;
	private BigDecimal amount;
	private LocalDateTime paymentDate;

}
