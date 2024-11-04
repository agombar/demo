package com.demo.users.processor.application.listener.user.mapper;

import com.demo.users.processor.application.listener.user.create.UserContentCreateMessage;
import com.demo.users.processor.application.listener.user.update.UserContentUpdateMessage;
import com.demo.users.processor.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMessageConsumeMapper {

	UserMessageConsumeMapper INSTANCE = Mappers.getMapper(UserMessageConsumeMapper.class);

	User toUser(UserContentCreateMessage message);

	User toUser(UserContentUpdateMessage message);

}
