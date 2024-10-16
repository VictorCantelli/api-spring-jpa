package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph (attributePaths = {"orders"})
    Optional<User> findById(Long id);

    @EntityGraph (attributePaths = {"orders"})
    List<User> findAll();
}