package com.demo.users.payments.sink.infrastructure.jpa.entity.user.mapper;

import com.demo.users.payments.sink.domain.model.User;
import com.demo.users.payments.sink.infrastructure.jpa.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

	UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

	UserEntity toUserEntity(User user);

	User toUser(UserEntity userEntity);

}
