package com.springTest.apiTest.services;

import com.springTest.apiTest.dto.CategoryDTO;
import com.springTest.apiTest.dto.ProductDTO;
import com.springTest.apiTest.entities.Product;
import com.springTest.apiTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return getProductDTO(product);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::getProductDTO).collect(Collectors.toList());
    }

    private ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());

        List<CategoryDTO> categoryDTOs = product.getCategories().stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .collect(Collectors.toList());

        productDTO.setCategories(categoryDTOs);
        return productDTO;
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElse(null);
    }
}