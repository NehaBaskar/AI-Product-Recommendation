package com.ai.retail.Product.Recommendation.repository;

import com.ai.retail.Product.Recommendation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(String category);
}
