package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.database.JDBCUtil;
import org.scoula.food.domain.RestaurantVO;

import java.io.FileReader;
import java.util.List;

public class ImportRestaurantData {
    public static void main (String[] args) throws Exception {
        RestaurantDao dao = new RestaurantDaoImpl();
        List<RestaurantVO> restaurants = new CsvToBeanBuilder<RestaurantVO>(new FileReader("restaurant.csv"))
                .withType(RestaurantVO.class)
                .build()
                .parse();
        restaurants.forEach(restaurant -> {
            System.out.println("저장 중: " + restaurant.getName());
            dao.insert(restaurant);
        });
        JDBCUtil.close();
    }
}