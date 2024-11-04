package com.demo.users.payments.api.infrastructure.jpa.entity.user;

import com.demo.users.payments.api.infrastructure.jpa.entity.payment.PaymentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "username", nullable = false, length = 50)
	private String username;

	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Transient
	private List<PaymentEntity> payments;

}
