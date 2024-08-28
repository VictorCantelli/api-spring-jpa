package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
