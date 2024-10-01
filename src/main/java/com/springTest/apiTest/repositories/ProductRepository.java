package com.springTest.apiTest.repositories;

import com.springTest.apiTest.dto.ProductDTO;
import com.springTest.apiTest.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    @EntityGraph(attributePaths = {"categories"})
    List<Product> findAll();
}
