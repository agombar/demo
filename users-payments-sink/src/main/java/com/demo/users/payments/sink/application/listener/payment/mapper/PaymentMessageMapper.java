package com.demo.users.payments.sink.application.listener.payment.mapper;

import com.demo.users.payments.sink.application.listener.payment.dto.create.PaymentContentCreateMessage;
import com.demo.users.payments.sink.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PaymentMessageMapper {

	PaymentMessageMapper INSTANCE = Mappers.getMapper(PaymentMessageMapper.class);

	@Mapping(target = "user.id", source = "userId")
	Payment toPayment(PaymentContentCreateMessage message);

}
