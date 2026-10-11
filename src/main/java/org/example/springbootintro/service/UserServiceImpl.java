package org.example.springbootintro.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootintro.dto.user.UserRegistrationRequestDto;
import org.example.springbootintro.dto.user.UserResponseDto;
import org.example.springbootintro.exception.RegistrationException;
import org.example.springbootintro.mapper.UserMapper;
import org.example.springbootintro.model.User;
import org.example.springbootintro.repository.mainrepository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRequestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new RegistrationException("email already exist");
        }

        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setPassword(userRequestDto.getPassword());
        user.setShippingAddress(userRequestDto.getShippingAddress());
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }
}
