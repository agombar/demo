package com.demo.users.payments.api.domain.repository;


import com.demo.users.payments.api.domain.model.Paging;
import com.demo.users.payments.api.domain.model.Payment;
import com.demo.users.payments.api.domain.model.Search;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {

	Optional<Payment> findById(UUID id);

	Search<Payment> findByUserId(UUID userId, Paging paging);

}
