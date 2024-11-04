package com.demo.users.payments.api.infrastructure.jpa.entity.user.mapper;

import com.demo.users.payments.api.domain.model.User;
import com.demo.users.payments.api.infrastructure.jpa.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

	UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

	UserEntity toUserEntity(User user);

	User toUser(UserEntity userEntity);

}
