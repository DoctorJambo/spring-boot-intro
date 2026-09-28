package org.example.springbootintro.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.CreateBookRequestDto;
import org.example.springbootintro.exception.EntityNotFoundException;
import org.example.springbootintro.mapper.BookMapper;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toBook(requestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
        public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("can't find book by id: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto updateById(CreateBookRequestDto bookDto, Long id) {
        Book bookById = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("can't find book by id: " + id));
        bookMapper.updateBook(bookDto, bookById);
        bookRepository.save(bookById);
        return bookMapper.toDto(bookById);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
