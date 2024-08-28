package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
