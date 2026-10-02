package org.example.springbootintro.dto;

import jakarta.validation.constraints.NotNull;

public record BookSearchParametersDto(@NotNull String titlePart, @NotNull String author) {

}
