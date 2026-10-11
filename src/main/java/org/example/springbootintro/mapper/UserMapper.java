package org.example.springbootintro.mapper;

import org.example.springbootintro.config.MapperConfig;
import org.example.springbootintro.dto.user.UserRegistrationRequestDto;
import org.example.springbootintro.dto.user.UserResponseDto;
import org.example.springbootintro.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toUserDto(User user);

    User toUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
