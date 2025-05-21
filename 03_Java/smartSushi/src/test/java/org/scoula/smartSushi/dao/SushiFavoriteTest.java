package org.scoula.smartSushi.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.scoula.smartSushi.common.JDBCUtil;
import org.scoula.smartSushi.domain.SushiLogStat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

class SushiFavoriteTest {
    SushiDao dao = new SushiDaoImpl();

    @BeforeEach
    void setUp () throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
        dao.insertSushiLog("cust01", "gold");
    }

    @AfterEach
    void tearDown () {
        JDBCUtil.close();
    }

    @Test
    void findFavoriteColor () throws SQLException {
        Optional<SushiLogStat> stat = dao.findFavoriteColor("cust01");
        if (stat.isPresent()) {
            System.out.println(stat.get());
        } else {
            System.out.println("⚠\uFE0F 접시 기록이 없어 분석할 수 없습니다.");
        }
    }
}