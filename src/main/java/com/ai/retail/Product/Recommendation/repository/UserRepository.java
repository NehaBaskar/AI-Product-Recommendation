package com.ai.retail.Product.Recommendation.repository;

import com.ai.retail.Product.Recommendation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
