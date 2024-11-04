package com.demo.users.payments.api.application.controller.user.mapper;

import com.demo.users.payments.api.application.controller.user.response.UserResponse;
import com.demo.users.payments.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

	UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

	UserResponse toUserResponse(User user);

}
