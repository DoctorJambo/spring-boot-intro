package org.example.springbootintro.repository.specification_provider;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    Specification<T> getSpecification(String param);
}
