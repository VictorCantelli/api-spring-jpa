package com.springTest.apiTest.repositories;

import com.springTest.apiTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
