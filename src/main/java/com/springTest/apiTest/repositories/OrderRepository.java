package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.Order;
import com.springTest.apiTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
