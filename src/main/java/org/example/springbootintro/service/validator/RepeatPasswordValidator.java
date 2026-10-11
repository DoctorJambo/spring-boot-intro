package org.example.springbootintro.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.example.springbootintro.annotations.FieldMatch;
import org.example.springbootintro.dto.user.UserRegistrationRequestDto;

public class RepeatPasswordValidator implements
        ConstraintValidator<FieldMatch, UserRegistrationRequestDto> {

    @Override
    public boolean isValid(
            UserRegistrationRequestDto requestDto,
            ConstraintValidatorContext context
    ) {
        return Objects.equals(requestDto.getPassword(), requestDto.getRepeatPassword());
    }
}
