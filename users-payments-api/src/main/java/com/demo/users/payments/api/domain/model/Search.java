package com.demo.users.payments.api.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Search<T> {

	private final List<T> content;
	private final int currentPage;
	private final long totalItems;
	private final int totalPages;

}
