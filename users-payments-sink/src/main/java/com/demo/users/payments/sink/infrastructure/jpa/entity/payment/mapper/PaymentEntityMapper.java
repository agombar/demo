package com.demo.users.payments.sink.infrastructure.jpa.entity.payment.mapper;

import com.demo.users.payments.sink.domain.model.Payment;
import com.demo.users.payments.sink.infrastructure.jpa.entity.payment.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

	PaymentEntityMapper INSTANCE = Mappers.getMapper(PaymentEntityMapper.class);

	PaymentEntity toPaymentEntity(Payment payment);

	Payment toPayment(PaymentEntity paymentEntity);

}
