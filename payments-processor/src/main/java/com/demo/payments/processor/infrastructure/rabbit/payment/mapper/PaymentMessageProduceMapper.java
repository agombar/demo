package com.demo.payments.processor.infrastructure.rabbit.payment.mapper;

import com.demo.payments.processor.domain.model.Payment;
import com.demo.payments.processor.infrastructure.rabbit.payment.create.PaymentContentCreateMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMessageProduceMapper {

	PaymentMessageProduceMapper INSTANCE = Mappers.getMapper(PaymentMessageProduceMapper.class);

	PaymentContentCreateMessage toPaymentCreatedMessage(Payment payment);

}
