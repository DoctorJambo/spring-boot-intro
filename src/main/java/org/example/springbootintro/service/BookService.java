package org.example.springbootintro.service;

import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.BookSearchParametersDto;
import org.example.springbootintro.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto updateById(CreateBookRequestDto bookDto, Long id);

    void deleteById(Long id);

    Page<BookDto> search(BookSearchParametersDto params, Pageable pageable);
}
