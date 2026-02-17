package com.ai.retail.Product.Recommendation.repository;

import com.ai.retail.Product.Recommendation.model.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository  extends JpaRepository<UserActivity, Long> {
    List<UserActivity> findByUserId(Long userId);
}
