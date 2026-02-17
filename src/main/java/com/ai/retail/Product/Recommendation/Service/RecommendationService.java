package com.ai.retail.Product.Recommendation.Service;

import com.ai.retail.Product.Recommendation.model.Product;
import com.ai.retail.Product.Recommendation.model.UserActivity;
import com.ai.retail.Product.Recommendation.repository.ProductRepository;
import com.ai.retail.Product.Recommendation.repository.UserActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserActivityRepository userActivityRepository;
    private final ProductRepository productRepository;

    public List<Product> recommendProducts(Long userId){
        List<UserActivity> activities = userActivityRepository.findByUserId(userId);

        if(activities.isEmpty()){
            return productRepository.findAll();
        }
        //LastActivity of User
        UserActivity lastActivity = activities.get(activities.size()-1);

        Product product = productRepository.findById(lastActivity.getProductId()).orElseThrow();

        return productRepository.findProductByCategory(product.getCategory());

    }
}
