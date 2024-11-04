package com.demo.users.payments.api.application.controller.user;

import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.application.controller.user.mapper.UserResponseMapper;
import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.demo.users.payments.api.application.controller.user.response.UserResponseBuilder;
import com.demo.users.payments.api.builder.FakeUuid;
import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.model.UserBuilder;
import com.demo.users.payments.api.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersApiControllerTest {

	@InjectMocks
	private UsersApiController controller;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserResponseMapper userResponseMapper;

	@Test
	void when_user_id_is_given_then_it_is_retrieve() {
		this.controller.getUser(
			FakeUuid.uuid(3)
		);

		verify(this.userRepository).findById(FakeUuid.uuid(3));
	}

	@Test
	void when_user_is_retrieve_then_it_is_mapped() {
		when(this.userRepository.findById(any())).thenReturn(Optional.of(new UserBuilder().build(3)));

		this.controller.getUser(
			FakeUuid.uuid(3)
		);

		verify(this.userResponseMapper).toUserResponse(new UserBuilder().build(3));
	}


	@Test
	void when_user_is_mapped_then_it_is_returned() {
		when(this.userRepository.findById(any())).thenReturn(Optional.of(new UserBuilder().build(3)));
		when(this.userResponseMapper.toUserResponse(any())).thenReturn(new UserResponseBuilder().build(3));

		ResponseEntity<Response<UserResponse>> user = this.controller.getUser(
			FakeUuid.uuid(3)
		);

		assertThat(user.getBody().getContent()).isEqualTo(new UserResponseBuilder().build(3));
	}

	@Test
	void when_users_are_searched_given_then_it_is_retrieve() {
		when(this.userRepository.findAll(any())).thenReturn(
			new Search<>(
				List.of(new UserBuilder().build(3)),
				0,
				1,
				1
			)
		);

		this.controller.getUsers(
			1, 0
		);

		verify(this.userRepository).findAll(new Paging(0, 1));
	}

	@Test
	void when_users_are_retrieve_then_it_is_mapped() {
		when(this.userRepository.findAll(any())).thenReturn(
			new Search<>(
				List.of(new UserBuilder().build(3)),
				0,
				1,
				1
			)
		);

		this.controller.getUsers(
			1, 0
		);

		verify(this.userResponseMapper).toUserResponse(new UserBuilder().build(3));
	}


	@Test
	void when_users_are_mapped_then_it_is_returned() {
		when(this.userRepository.findAll(any())).thenReturn(
			new Search<>(
				List.of(new UserBuilder().build(3)),
				0,
				1,
				1
			)
		);
		when(this.userResponseMapper.toUserResponse(any())).thenReturn(new UserResponseBuilder().build(3));

		ResponseEntity<Search<UserResponse>> user = this.controller.getUsers(
			1, 0
		);

		assertThat(user.getBody().getContent()).isEqualTo(List.of(new UserResponseBuilder().build(3)));
	}

}