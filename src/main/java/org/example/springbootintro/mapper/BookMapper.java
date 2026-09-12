package org.example.springbootintro.mapper;

import org.example.springbootintro.config.MapperConfig;
import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.CreateBookRequestDto;
import org.example.springbootintro.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toBook(CreateBookRequestDto bookRequestDto);
}
