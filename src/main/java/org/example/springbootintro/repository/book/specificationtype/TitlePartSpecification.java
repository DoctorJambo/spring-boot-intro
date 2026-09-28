package org.example.springbootintro.repository.book.specificationtype;

import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitlePartSpecification implements SpecificationProvider<Book> {
    @Override
    public Specification<Book> getSpecification(String titlePart) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("title")),
                        "%" + titlePart.toLowerCase() + "%");
    }
}
