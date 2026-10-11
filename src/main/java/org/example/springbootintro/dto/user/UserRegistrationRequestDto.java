package org.example.springbootintro.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.springbootintro.annotations.FieldMatch;

@FieldMatch
@Getter
@Setter
public class UserRegistrationRequestDto {
    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String shippingAddress;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;
}
