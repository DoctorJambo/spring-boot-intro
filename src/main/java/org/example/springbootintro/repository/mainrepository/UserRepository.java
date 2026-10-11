package org.example.springbootintro.repository.mainrepository;

import java.util.Optional;
import org.example.springbootintro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<String> findByEmail(String email);
}
