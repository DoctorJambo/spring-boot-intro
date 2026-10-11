package org.example.springbootintro.service;

import org.example.springbootintro.dto.user.UserRegistrationRequestDto;
import org.example.springbootintro.dto.user.UserResponseDto;
import org.example.springbootintro.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}
