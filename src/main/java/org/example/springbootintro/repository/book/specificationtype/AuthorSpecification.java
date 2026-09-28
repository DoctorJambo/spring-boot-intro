package org.example.springbootintro.repository.book.specificationtype;

import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecification implements SpecificationProvider<Book> {
    @Override
    public Specification<Book> getSpecification(String author) {
        return (root, query, cb) -> cb.equal(root.get("author"), author);
    }
}
