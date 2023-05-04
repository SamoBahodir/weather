package com.weather.entity.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toDto(User user);
}
