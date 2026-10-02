package org.example.springbootintro.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.springbootintro.customannotation.StartWithUpper;

public class WordsStyleValidator implements ConstraintValidator<StartWithUpper, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Character.isUpperCase(value.charAt(0));
    }
}
