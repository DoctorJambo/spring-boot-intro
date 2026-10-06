package org.example.springbootintro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.BookSearchParametersDto;
import org.example.springbootintro.dto.CreateBookRequestDto;
import org.example.springbootintro.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book management", description = "Endpoints for managing books")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @Operation(summary = "get all books", description = "get all entities from data base")
    @ApiResponse(responseCode = "200", description = "Books found")
    @ApiResponse(responseCode = "404", description = "Books not found")
    @GetMapping
    public Page<BookDto> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(
                        Sort.Order.asc("author"),
                        Sort.Order.desc("title")
                )
        );

        return bookService.findAll(pageable);
    }

    @Operation(summary = "get book by id", description = "retrieves entity by its id")
    @ApiResponse(responseCode = "200", description = "Book found by id")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Operation(summary = "create book", description = "create and add new entity to DB")
    @ApiResponse(responseCode = "201", description = "Book created")
    @ApiResponse(responseCode = "400", description = "wrong request params")
    @PostMapping
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }

    @Operation(summary = "update by id", description = "update all info about entity")
    @ApiResponse(responseCode = "200", description = "Book updated by id")
    @ApiResponse(responseCode = "400", description = "wrong request params")
    @PutMapping("/{id}")
    public BookDto updateBookById(
            @RequestBody @Valid CreateBookRequestDto bookDto,
            @PathVariable Long id
    ) {
        return bookService.updateById(bookDto, id);
    }

    @Operation(summary = "delete by id", description = "mark entity like is_deleted")
    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Book deleted")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @Operation(summary = "search book", description = "get list of entities by params")
    @ApiResponse(responseCode = "200", description = "Books found")
    @ApiResponse(responseCode = "400", description = "wrong request params")
    @GetMapping("/search")
    public Page<BookDto> search(@RequestBody BookSearchParametersDto searchParameters, Pageable pageable) {
        return bookService.search(searchParameters, pageable);
    }
}
