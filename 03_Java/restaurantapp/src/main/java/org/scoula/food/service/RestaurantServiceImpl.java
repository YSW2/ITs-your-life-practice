package org.scoula.food.service;

import lombok.RequiredArgsConstructor;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    final RestaurantDao dao;

    @Override
    public void printAllRestaurantAvgScore () {
        List<RestaurantVO> scoreList = dao.getAllRestaurantWithScoreAvg();
        int index = 1;

        System.out.println("맛집 평균 평점 순위");
        for (RestaurantVO result : scoreList) {
            if (Double.compare(result.getAverageScore(), 0) != 0)
                System.out.println(index + ". " + result.getName() + " (" + result.getAverageScore() + "점) - " + result.getAddress());
            else
                System.out.println(index + ". " + result.getName() + " (점수 없음) - " + result.getAddress());
            index++;
        }
    }

    @Override
    public void printRestaurantWithReviews () {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 맛집 ID를 입력하세요: ");
        long id = sc.nextLong();
        Optional<RestaurantVO> restaurantVO = dao.getRestaurantWithReviews(id);
        if (restaurantVO.isPresent()) {
            RestaurantVO result = restaurantVO.get();

            System.out.println("[맛집 정보]");
            System.out.println("이름: " + result.getName());
            System.out.println("카테고리: " + result.getCategory());
            System.out.println("주소: " + result.getAddress());
            System.out.println("설명: " + result.getDescription());
            System.out.println();
            System.out.println("[리뷰 목록]");
            for (RestaurantReviewVO review : result.getReviews()) {
                System.out.println("- " + review.getWriter() + " (" + review.getScore() + "점): " + review.getContent());
            }
        }
    }
}
