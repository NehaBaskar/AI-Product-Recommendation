package com.ai.retail.Product.Recommendation.controller;

import com.ai.retail.Product.Recommendation.Service.RecommendationService;
import com.ai.retail.Product.Recommendation.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<Product> productRecommendations(@PathVariable Long userId){
        return recommendationService.recommendProducts(userId);
    }


}
