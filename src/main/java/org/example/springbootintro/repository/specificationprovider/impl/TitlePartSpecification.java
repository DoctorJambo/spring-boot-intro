package org.example.springbootintro.repository.specificationprovider.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.repository.specificationprovider.SpecificationProvider;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitlePartSpecification implements SpecificationProvider<Book> {
    private static final String TITLE = "title";

    @Override
    public Specification<Book> getSpecification(String param) {
        return new Specification<Book>() {
            @Override
            public @Nullable Predicate toPredicate(
                    @NonNull Root<Book> root,
                    @NonNull CriteriaQuery<?> query,
                    @NonNull CriteriaBuilder cb) {

                return cb.like(root.get(TITLE), "%" + param + "%");
            }
        };
    }
}
