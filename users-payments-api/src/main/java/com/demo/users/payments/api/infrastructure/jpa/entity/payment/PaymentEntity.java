package com.demo.users.payments.api.infrastructure.jpa.entity.payment;

import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "payments")
public class PaymentEntity {

	@Id
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private UUID id;

	@Column(name = "amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "payment_date", nullable = false)
	private LocalDateTime paymentDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

}
