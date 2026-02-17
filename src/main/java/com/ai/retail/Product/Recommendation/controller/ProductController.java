package com.ai.retail.Product.Recommendation.controller;

import com.ai.retail.Product.Recommendation.model.Product;
import com.ai.retail.Product.Recommendation.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
