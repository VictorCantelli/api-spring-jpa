package com.springTest.apiTest.config;

import com.springTest.apiTest.entities.Category;
import com.springTest.apiTest.entities.Order;
import com.springTest.apiTest.entities.OrderStatus;
import com.springTest.apiTest.entities.User;
import com.springTest.apiTest.repositories.CategoryRepository;
import com.springTest.apiTest.repositories.OrderRepository;
import com.springTest.apiTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Hamburgueres");
        Category category2 = new Category(null, "Pizzas");
        Category category3 = new Category(null, "Bebidas");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        User u1 = new User(null, "NameTest1", "emailTest1@email.com", "9999999", "123456");
        User u2 = new User(null, "NameTest2", "emailTest2@email.com", "9999991", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELLED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
