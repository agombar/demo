package com.demo.users.payments.api.application.controller.ping;

import com.demo.users.payments.api.application.controller.ping.response.EmptyResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PingController {

	@Operation(hidden = true)
	@GetMapping(path = "/ping", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<EmptyResponse> ping() {
		return ResponseEntity.status(HttpStatus.OK).body(new EmptyResponse());
	}

}
