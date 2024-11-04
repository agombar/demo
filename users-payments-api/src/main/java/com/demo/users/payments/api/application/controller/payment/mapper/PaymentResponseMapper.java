package com.demo.users.payments.api.application.controller.payment.mapper;

import com.demo.users.payments.api.application.controller.payment.response.PaymentResponse;
import com.demo.users.payments.api.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentResponseMapper {

	PaymentResponseMapper INSTANCE = Mappers.getMapper(PaymentResponseMapper.class);

	PaymentResponse toPaymentResponse(Payment payment);

}
