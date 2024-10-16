package com.springTest.apiTest.dto;

import com.springTest.apiTest.entities.OrderItem;

public class OrderItemDTO {
    private Long product_id;
    private String product_name;
    private double price;
    private int quantity;
    private double subtotal;

    public OrderItemDTO(){
    }

    public OrderItemDTO(OrderItem orderItem){
        this.product_id = orderItem.getProduct().getId();
        this.product_name = orderItem.getProduct().getName();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
        this.subtotal = orderItem.getSubTotal();
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
