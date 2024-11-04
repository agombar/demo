package com.demo.users.payments.api.domain.repository;

import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

	Optional<User> findById(UUID id);

	Search<User> findAll(Paging paging);

}
