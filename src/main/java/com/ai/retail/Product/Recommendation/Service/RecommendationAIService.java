package com.ai.retail.Product.Recommendation.Service;

import com.ai.retail.Product.Recommendation.model.Product;
import com.ai.retail.Product.Recommendation.model.UserActivity;
import com.ai.retail.Product.Recommendation.repository.ProductRepository;
import com.ai.retail.Product.Recommendation.repository.UserActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecommendationAIService {

    @Value("${ai.api-key}")
    private String apiKey;

    private final UserActivityRepository userActivityRepository;
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate = new RestTemplate(
    );

    public String getAIRecommendations(Long userId) {

        List<UserActivity> userActivities = userActivityRepository.findByUserId(userId);
        List<Product> products = productRepository.findAll();

        String prompt = buildPrompt(userActivities, products);
        return callOpenAI(prompt);
    }

    public String buildPrompt(List<UserActivity> userActivities, List<Product> products) {
        return """
                you are a retail recommendation engine.
                user activities : %s
                product catalog: %s
                                
                Recommend 5 products with short reason
                """.formatted(userActivities, products);
    }

    public String callOpenAI(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Build request body as Java objects (NOT string)
        Map<String, Object> body = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                )
        );

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                entity,
                String.class
        );

        return response.getBody();
    }

}
