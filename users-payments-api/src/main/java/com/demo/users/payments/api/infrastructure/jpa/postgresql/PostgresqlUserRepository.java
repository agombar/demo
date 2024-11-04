package com.demo.users.payments.api.infrastructure.jpa.postgresql;

import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.model.User;
import com.demo.users.payments.api.domain.repository.UserRepository;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.mapper.UserEntityMapper;
import com.demo.users.payments.api.infrastructure.jpa.persistence.PostgresqlRepository;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class PostgresqlUserRepository implements UserRepository {

	private final PostgresqlRepository<UserEntity> postgresqlRepository;
	private final UserEntityMapper userEntityMapper;

	@Override
	public Optional<User> findById(UUID id) {
		UserEntity userEntity = this.postgresqlRepository.fetchOne((builder, query) -> {
			Root<UserEntity> root = query.from(UserEntity.class);

			query
				.select(root)
				.where(builder.equal(root.get("id"), id));
		}, UserEntity.class);

		return Optional.ofNullable(userEntity).map(this.userEntityMapper::toUser);
	}

	@Override
	public Search<User> findAll(Paging paging) {
		Page<User> page = this.postgresqlRepository.fetch(
			(builder, query) -> {
				Root<UserEntity> root = query.from(UserEntity.class);
				query.select(root);
			},
			UserEntity.class,
			paging.getPage(),
			paging.getSize()
		).map(this.userEntityMapper::toUser);

		return new Search<>(
			page.getContent(),
			page.getNumber(),
			page.getTotalElements(),
			page.getTotalPages()
		);
	}

}
