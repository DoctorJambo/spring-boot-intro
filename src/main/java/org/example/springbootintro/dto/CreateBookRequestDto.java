package org.example.springbootintro.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.example.springbootintro.customannotation.StartWithUpper;

@Getter
@Setter
public class CreateBookRequestDto {
    @StartWithUpper
    private String title;
    @StartWithUpper
    private String author;
    @NotNull
    @Size(min = 5)
    private String isbn;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    private String description;
    @NotNull
    private String coverImage;
}
