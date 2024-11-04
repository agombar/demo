package com.demo.payments.processor.intrastructure.rabbit.payment.create.creator;

import com.demo.payments.processor.domain.model.PaymentBuilder;
import com.demo.payments.processor.infrastructure.rabbit.header.MessageHeaderCreator;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentCreateMessage;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.creator.PaymentCreateMessageCreator;
import com.demo.payments.processor.infrastructure.rabbit.payment.mapper.PaymentMessageProduceMapper;
import com.demo.payments.processor.intrastructure.rabbit.header.MessageHeaderBuilder;
import com.demo.payments.processor.intrastructure.rabbit.payment.create.PaymentContentCreateMessageBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentCreateMessageCreatorTest {

	@InjectMocks
	private PaymentCreateMessageCreator creator;

	@Mock
	private MessageHeaderCreator messageHeaderCreator;
	@Mock
	private PaymentMessageProduceMapper paymentMessageProduceMapper;

	@Test
	void when_values_are_given_then_header_is_mapped() {
		when(this.messageHeaderCreator.create(anyString()))
			.thenReturn(new MessageHeaderBuilder().build(3));
		when(this.paymentMessageProduceMapper.toPaymentCreatedMessage(any()))
			.thenReturn(new PaymentContentCreateMessageBuilder().build(4));

		this.creator.create(new PaymentBuilder().build(5));

		verify(this.messageHeaderCreator).create("payment-created");
	}

	@Test
	void when_values_are_given_then_content_is_mapped() {
		when(this.messageHeaderCreator.create(anyString()))
			.thenReturn(new MessageHeaderBuilder().build(3));
		when(this.paymentMessageProduceMapper.toPaymentCreatedMessage(any()))
			.thenReturn(new PaymentContentCreateMessageBuilder().build(4));

		this.creator.create(new PaymentBuilder().build(5));

		verify(this.paymentMessageProduceMapper).toPaymentCreatedMessage(new PaymentBuilder().build(5));
	}

	@Test
	void when_values_are_given_then_they_can_be_retrieved() {
		when(this.messageHeaderCreator.create(anyString()))
			.thenReturn(new MessageHeaderBuilder().build(3));
		when(this.paymentMessageProduceMapper.toPaymentCreatedMessage(any()))
			.thenReturn(new PaymentContentCreateMessageBuilder().build(4));

		PaymentCreateMessage message = this.creator.create(new PaymentBuilder().build(5));

		assertThat(message.getHeader()).isEqualTo(new MessageHeaderBuilder().build(3));
		assertThat(message.getContent()).isEqualTo(new PaymentContentCreateMessageBuilder().build(4));
	}

}