package com.springTest.apiTest.dto;
import com.springTest.apiTest.entities.Category;
import com.springTest.apiTest.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDTO {
    private Long id;
    private String name;
    private List<CategoryDTO> categories;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
