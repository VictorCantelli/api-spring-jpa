package com.springTest.apiTest.controllers;

import com.springTest.apiTest.dto.ProductDTO;
import com.springTest.apiTest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }


    @GetMapping(value = "/{id}")
    @Transactional
    public ProductDTO findById(@PathVariable Long id) {
        return productService.getProductById(id);
    };
}