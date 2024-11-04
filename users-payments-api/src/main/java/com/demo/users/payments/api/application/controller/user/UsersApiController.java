package com.demo.users.payments.api.application.controller.user;

import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.application.controller.user.mapper.UserResponseMapper;
import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Search;
import com.demo.users.payments.api.domain.model.User;
import com.demo.users.payments.api.domain.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersApiController implements UsersApi {

	private final UserRepository userRepository;
	private final UserResponseMapper userResponseMapper;

	@Override
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<UserResponse>> getUser(@PathVariable("id") UUID id) {
		Optional<User> user = this.userRepository.findById(id);

		return user
			.map(value -> ResponseEntity.ok(new Response<>(this.userResponseMapper.toUserResponse(value))))
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Override
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Search<UserResponse>> getUsers(@PathParam("size") int size, @PathParam("page") int page) {
		Search<User> users = this.userRepository.findAll(new Paging(page, size));
		return ResponseEntity.ok(
			new Search<>(
				users.getContent().stream().map(this.userResponseMapper::toUserResponse).collect(Collectors.toList()),
				users.getCurrentPage(),
				users.getTotalItems(),
				users.getTotalPages()
			)
		);
	}

}
