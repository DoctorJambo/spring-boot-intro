package org.example.springbootintro.repository;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springbootintro.dto.BookSearchParametersDto;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.book.specificationtype.AuthorSpecification;
import org.example.springbootintro.repository.book.specificationtype.TitlePartSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final TitlePartSpecification titlePartSpecification;
    private final AuthorSpecification authorSpecification;

    @Override
    public Specification<Book> build(BookSearchParametersDto params) {
        List<Specification<Book>> specifications = new ArrayList<>();

        if (params.titlePart() != null && !params.titlePart().isBlank()) {
            specifications.add(titlePartSpecification.getSpecification(params.titlePart()));
        }
        if (params.author() != null && !params.author().isBlank()) {
            specifications.add(authorSpecification.getSpecification(params.author()));
        }
        return Specification.allOf(specifications);
    }
}
