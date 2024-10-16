package com.springTest.apiTest.dto;

import com.springTest.apiTest.entities.Order;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    private Long id;
    private Instant date;
    private UserDTO client;
    private List<OrderItemDTO> items;
    private Double total;

    public OrderDTO() {
    }

    public OrderDTO(Order order){
        this.id = order.getId();
        this.date = order.getDate();
        this.client = new UserDTO(order.getClient());
        this.items = order.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
        this.total = order.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public UserDTO getClient() {
        return client;
    }

    public void setClient(UserDTO client) {
        this.client = client;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}