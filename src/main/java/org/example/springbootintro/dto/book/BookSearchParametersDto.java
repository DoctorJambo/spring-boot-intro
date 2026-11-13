package org.example.springbootintro.dto.book;

import jakarta.validation.constraints.NotBlank;

public record BookSearchParametersDto(@NotBlank String titlePart, @NotBlank String author) {

}
