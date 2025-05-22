package org.scoula.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantVO {
    private Long id;
    private String name;
    private String category;
    private String address;
    private String description;
    private List<RestaurantReviewVO> reviews;  // 리뷰 리스트 포함
    private Double averageScore;
}