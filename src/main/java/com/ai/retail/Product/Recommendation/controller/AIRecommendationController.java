package com.ai.retail.Product.Recommendation.controller;

import com.ai.retail.Product.Recommendation.Service.RecommendationAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai-recommendations")
@RequiredArgsConstructor
public class AIRecommendationController {

    private final RecommendationAIService recommendationAIService;

    @GetMapping("/{userId}")
    public String getAIRecommendedProducts(@PathVariable Long userId){
        return  recommendationAIService.getAIRecommendations(userId);
    }
}
