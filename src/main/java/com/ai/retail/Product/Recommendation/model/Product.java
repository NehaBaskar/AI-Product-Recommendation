package com.ai.retail.Product.Recommendation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    @Column(length = 2000)
    private String description;

}
