package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.Order;
import com.springTest.apiTest.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph (attributePaths = {"client", "items", "items.id.product"})
    Optional<Order> findById(Long id);

    @EntityGraph (attributePaths = {"client", "items", "items.id.product"})
    List<Order> findAll();

}
