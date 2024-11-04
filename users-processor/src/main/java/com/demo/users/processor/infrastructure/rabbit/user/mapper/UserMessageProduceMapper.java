package com.demo.users.processor.infrastructure.rabbit.user.mapper;

import com.demo.users.processor.domain.model.User;
import com.demo.users.processor.infrastructure.rabbit.user.create.UserContentCreateMessage;
import com.demo.users.processor.infrastructure.rabbit.user.update.UserContentUpdateMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMessageProduceMapper {

	UserMessageProduceMapper INSTANCE = Mappers.getMapper(UserMessageProduceMapper.class);

	UserContentCreateMessage toUserCreatedMessage(User user);

	UserContentUpdateMessage toUserUpdatedMessage(User user);

}
