package com.demo.users.payments.sink.infrastructure.jpa.postgresql;

import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.exception.ResourceUpdateException;
import com.demo.users.payments.sink.domain.model.User;
import com.demo.users.payments.sink.domain.repository.UserRepository;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.UserEntity;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.mapper.UserEntityMapper;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.PostgresqlRepository;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.QueryExecuteException;
import com.demo.users.payments.sink.infrastructure.jpa.persistence.QueryInsertException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class PostgresqlUserRepository implements UserRepository {

	private final PostgresqlRepository<UserEntity> postgresqlRepository;
	private final UserEntityMapper userEntityMapper;
	private final Clock clock;

	@Override
	public User create(User user) throws ResourceCreateException {
		UserEntity userEntity = this.userEntityMapper.toUserEntity(user)
			.setCreatedAt(LocalDateTime.now(this.clock));
		try {
			return this.userEntityMapper.toUser(
				this.postgresqlRepository.insert(userEntity)
			);
		} catch(QueryInsertException e) {
			throw new ResourceCreateException(String.format("Cannot create user %s", user), e);
		}
	}

	@Override
	public User update(User user) throws ResourceUpdateException {
		try {
			this.postgresqlRepository.update((CriteriaBuilder builder, CriteriaUpdate<UserEntity> query) -> {
				Root<UserEntity> root = query.from(UserEntity.class);

				query
					.set("username", user.getUsername())
					.set("email", user.getEmail())
					.set("updatedAt", LocalDateTime.now(this.clock))
					.where(builder.equal(root.get("id"), user.getId()));


			}, UserEntity.class);
		} catch(QueryExecuteException e) {
			throw new ResourceUpdateException(String.format("Cannot update user %s", user), e);
		}

		return this.findById(user.getId())
			.orElseThrow(() -> new ResourceUpdateException(String.format(
				"User %s not found and could not be updated",
				user.getId()
			)));
	}

	private Optional<User> findById(UUID id) {
		UserEntity userEntity = this.postgresqlRepository.fetchOne((builder, query) -> {
			Root<UserEntity> root = query.from(UserEntity.class);

			query
				.select(root)
				.where(builder.equal(root.get("id"), id));
		}, UserEntity.class);

		return Optional.ofNullable(userEntity).map(this.userEntityMapper::toUser);
	}

}
