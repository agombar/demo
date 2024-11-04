package com.demo.users.payments.sink.application.bean;

import com.demo.users.payments.sink.domain.repository.PaymentRepository;
import com.demo.users.payments.sink.domain.repository.UserRepository;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.PaymentEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.mapper.PaymentEntityMapper;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.UserEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.mapper.UserEntityMapper;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.PostgresqlRepository;
import com.demo.users.payments.sink.infrastructure.jpa.postgresql.PostgresqlPaymentRepository;
import com.demo.users.payments.sink.infrastructure.jpa.postgresql.PostgresqlUserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;


@Configuration
public class Repository {

	@Bean
	public PostgresqlRepository<PaymentEntity> paymentPostgresqlRepository(EntityManager entityManager) {
		return new PostgresqlRepository<>(entityManager);
	}

	@Bean
	public PaymentRepository paymentRepository(
		PostgresqlRepository<PaymentEntity> postgresqlRepository,
		Clock clock
	) {
		return new PostgresqlPaymentRepository(
			postgresqlRepository,
			PaymentEntityMapper.INSTANCE,
			clock
		);
	}

	@Bean
	public PostgresqlRepository<UserEntity> userPostgresqlRepository(EntityManager entityManager) {
		return new PostgresqlRepository<>(entityManager);
	}

	@Bean
	public UserRepository userRepository(
		PostgresqlRepository<UserEntity> postgresqlRepository,
		Clock clock
	) {
		return new PostgresqlUserRepository(
			postgresqlRepository,
			UserEntityMapper.INSTANCE,
			clock
		);
	}

}
