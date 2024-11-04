package com.demo.users.payments.api.application.controller.user;

import com.demo.users.payments.api.application.controller.response.Response;
import com.demo.users.payments.api.application.controller.response.error.ErrorResponse;
import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.demo.users.payments.api.domain.model.Search;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UsersApi {

	@Operation(
		summary = "Get user",
		description = "Get user",
		operationId = "getUser",
		tags = "User")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "User detail have been returned successfully"),
		@ApiResponse(responseCode = "404", description = "User not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Response<UserResponse>> getUser(
		@Parameter(name = "id", description = "User id", required = true) UUID id
	);

	@Operation(
		summary = "Search users",
		description = "Get users searched",
		operationId = "getUsers",
		tags = "User")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "User detail have been returned successfully"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Search<UserResponse>> getUsers(
		@Parameter(name = "size", description = "page size", required = true) int size,
		@Parameter(name = "page", description = "page number", required = true) int page
	);

}
