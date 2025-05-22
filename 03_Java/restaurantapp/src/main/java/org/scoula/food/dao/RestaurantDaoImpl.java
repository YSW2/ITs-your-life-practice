package org.scoula.food.dao;

import org.scoula.food.database.JDBCUtil;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection conn = JDBCUtil.getConnection();

    private RestaurantReviewVO reviewMap (ResultSet rs) throws SQLException {
        return RestaurantReviewVO.builder()
                .no(rs.getLong("no"))
                .restaurantId(rs.getLong("restaurant_id"))
                .writer(rs.getString("writer"))
                .content(rs.getString("content"))
                .score(rs.getInt("score"))
                .build();
    }

    private RestaurantVO scoreMap (ResultSet rs) throws SQLException {
        return RestaurantVO.builder()
                .name(rs.getString("name"))
                .address(rs.getString("address"))
                .averageScore(rs.getDouble("averageScore"))
                .build();
    }


    @Override
    public void insert (RestaurantVO restaurant) {
        String sql = "insert into tbl_restaurant (name, category, address, description) values (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCategory());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getDescription());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertReview (RestaurantReviewVO review) {
        String sql = "INSERT INTO tbl_restaurant_review(restaurant_id, writer, content, score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, review.getRestaurantId());
            pstmt.setString(2, review.getWriter());
            pstmt.setString(3, review.getContent());
            pstmt.setInt(4, review.getScore());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RestaurantVO> getRestaurantWithReviews (Long id) {
        List<RestaurantReviewVO> reviews = new ArrayList<>();
        RestaurantVO restaurantVO = null;
        String sql = "select * from tbl_restaurant F left outer join tbl_restaurant_review R on F.id = R.restaurant_id where F.id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    restaurantVO = RestaurantVO.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .category(rs.getString("category"))
                            .address(rs.getString("address"))
                            .description(rs.getString("description"))
                            .reviews(reviews)
                            .build();
                    reviews.add(reviewMap(rs));
                }
                while (rs.next()) {
                    reviews.add(reviewMap(rs));
                }

                return Optional.of(restaurantVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RestaurantVO> getAllRestaurantWithScoreAvg () {
        List<RestaurantVO> scoreList = new ArrayList<>();
        String sql = """
                select F.name, round(AVG(R.score), 2) as averageScore, F.address
                from tbl_restaurant F
                         left outer join tbl_restaurant_review R on F.id = R.restaurant_id
                group by F.name, F.address
                order by averageScore desc
                """;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    scoreList.add(scoreMap(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return scoreList;
    }
}
