package com.demo.users.payments.sink.application.listener.user.mapper;

import com.demo.users.payments.sink.application.listener.user.dto.create.UserContentCreateMessage;
import com.demo.users.payments.sink.application.listener.user.dto.update.UserContentUpdateMessage;
import com.demo.users.payments.sink.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMessageMapper {

	UserMessageMapper INSTANCE = Mappers.getMapper(UserMessageMapper.class);

	User toUser(UserContentCreateMessage message);

	User toUser(UserContentUpdateMessage message);

}
