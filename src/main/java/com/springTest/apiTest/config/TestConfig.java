package com.springTest.apiTest.config;

import com.springTest.apiTest.entities.*;
import com.springTest.apiTest.repositories.*;
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
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Hamburgueres");
        Category category2 = new Category(null, "Pizzas");
        Category category3 = new Category(null, "Bebidas");

        Product p1 = new Product("", 29.9, "Hambúrguer com queijo, alface, tomate e molho especial.", "Classic Cheeseburger", null);
        Product p2 = new Product("", 45.0, "Pizza com molho de tomate, queijo e pepperoni.", "Pepperoni Pizza", null);
        Product p3 = new Product("", 3.5, "Refrigerante gaseificado sabor cola.", "Coca-Cola", null);
        Product p4 = new Product("", 34.9, "Hambúrguer com bacon, queijo cheddar e molho barbecue.", "BBQ Bacon Burger", null);
        Product p5 = new Product("", 43.0, "Pizza com molho de tomate, queijo, presunto e abacaxi.", "Hawaiian Pizza", null);
        Product p6 = new Product("", 2.0, "Água mineral sem gás.", "Água Mineral", null);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        p1.getCategories().add(category1);
        p4.getCategories().add(category1);
        p2.getCategories().add(category2);
        p5.getCategories().add(category2);
        p3.getCategories().add(category3);
        p6.getCategories().add(category3);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        User u1 = new User(null, "NameTest1", "emailTest1@email.com", "9999999", "123456");
        User u2 = new User(null, "NameTest2", "emailTest2@email.com", "9999991", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELLED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi4 = new OrderItem(o2, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
