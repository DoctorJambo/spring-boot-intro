package org.example.springbootintro.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
