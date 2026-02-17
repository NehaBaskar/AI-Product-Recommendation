package com.ai.retail.Product.Recommendation.controller;

import com.ai.retail.Product.Recommendation.model.UserActivity;
import com.ai.retail.Product.Recommendation.repository.UserActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final UserActivityRepository userActivityRepository;

    @PostMapping
    public UserActivity trackUserActivity(@RequestBody UserActivity userActivity){
        userActivity.setTimestamp(LocalDateTime.now());
        return userActivityRepository.save(userActivity);
    }

    @GetMapping("/{userId}")
    public List<UserActivity> getUserActivity(@PathVariable Long userId){
        return userActivityRepository.findByUserId(userId);
    }
}
