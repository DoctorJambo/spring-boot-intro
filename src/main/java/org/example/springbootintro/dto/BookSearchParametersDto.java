package org.example.springbootintro.dto;

import jakarta.validation.constraints.NotBlank;

public record BookSearchParametersDto(@NotBlank String titlePart, @NotBlank String author) {

}
