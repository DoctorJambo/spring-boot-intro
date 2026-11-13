package org.example.springbootintro.repository.mainrepository;

import jakarta.validation.constraints.NotBlank;
import org.example.springbootintro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(@NotBlank String email);
}
