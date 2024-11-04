package com.demo.payments.processor.application.listener.payment.mapper;

import com.demo.payments.processor.application.listener.payment.create.PaymentContentCreateMessage;
import com.demo.payments.processor.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PaymentMessageConsumeMapper {

	PaymentMessageConsumeMapper INSTANCE = Mappers.getMapper(PaymentMessageConsumeMapper.class);

	Payment toPayment(PaymentContentCreateMessage paymentDTO);

}
