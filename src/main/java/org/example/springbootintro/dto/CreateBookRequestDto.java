package org.example.springbootintro.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.example.springbootintro.annotations.StartWithUpper;

@Getter
@Setter
public class CreateBookRequestDto {
    @StartWithUpper
    @NotBlank
    private String title;
    @StartWithUpper
    @NotBlank
    private String author;
    @NotBlank
    @Size(min = 5)
    private String isbn;
    @NotBlank
    @Min(0)
    private BigDecimal price;
    @NotBlank
    private String description;
    @NotBlank
    private String coverImage;
}
