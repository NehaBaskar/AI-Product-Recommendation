package com.ai.retail.Product.Recommendation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    @Enumerated(EnumType.STRING)
    private ActionType action;
    private LocalDateTime timestamp;
}
