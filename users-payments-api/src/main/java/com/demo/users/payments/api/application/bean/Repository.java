package com.demo.users.payments.api.application.bean;

import com.demo.users.payments.api.domain.repository.PaymentRepository;
import com.demo.users.payments.api.domain.repository.UserRepository;
import com.demo.users.payments.api.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.api.infrastructure.jpa.entity.payment.mapper.PaymentEntityMapper;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.mapper.UserEntityMapper;
import com.demo.users.payments.api.infrastructure.jpa.persistence.PostgresqlRepository;
import com.demo.users.payments.api.infrastructure.jpa.postgresql.PostgresqlPaymentRepository;
import com.demo.users.payments.api.infrastructure.jpa.postgresql.PostgresqlUserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repository {

	@Bean
	public PostgresqlRepository<PaymentEntity> paymentPostgresqlRepository(EntityManager entityManager) {
		return new PostgresqlRepository<>(entityManager);
	}

	@Bean
	public PaymentRepository paymentRepository(
		PostgresqlRepository<PaymentEntity> postgresqlRepository
	) {
		return new PostgresqlPaymentRepository(
			postgresqlRepository,
			PaymentEntityMapper.INSTANCE
		);
	}

	@Bean
	public PostgresqlRepository<UserEntity> userPostgresqlRepository(EntityManager entityManager) {
		return new PostgresqlRepository<>(entityManager);
	}

	@Bean
	public UserRepository userRepository(
		PostgresqlRepository<UserEntity> postgresqlRepository
	) {
		return new PostgresqlUserRepository(
			postgresqlRepository,
			UserEntityMapper.INSTANCE
		);
	}

}
