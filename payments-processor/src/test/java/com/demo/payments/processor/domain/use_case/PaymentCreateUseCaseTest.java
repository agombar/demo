package com.demo.payments.processor.domain.use_case;

import com.demo.payments.processor.domain.exception.PublishMessageException;
import com.demo.payments.processor.domain.model.PaymentBuilder;
import com.demo.payments.processor.domain.service.MessagingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentCreateUseCaseTest {

	@InjectMocks
	private PaymentCreateUseCase useCase;

	@Mock
	private MessagingService messagingService;

	@Test
	void when_user_is_given_then_it_is_published() throws PublishMessageException {
		this.useCase.execute(new PaymentBuilder().build(3));

		verify(this.messagingService).publishPaymentCreated(new PaymentBuilder().build(3));
	}

}
