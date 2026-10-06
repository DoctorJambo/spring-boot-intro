package org.example.springbootintro.repository.specificationprovider;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    Specification<T> getSpecification(String param);
}
