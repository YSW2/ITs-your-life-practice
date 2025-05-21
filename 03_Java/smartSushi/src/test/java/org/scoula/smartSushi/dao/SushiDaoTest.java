package org.scoula.smartSushi.dao;

import org.junit.jupiter.api.*;
import org.scoula.smartSushi.common.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();

    @AfterAll
    static void tearDown () {
        JDBCUtil.close();
    }

    @BeforeEach
    void setUp () throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
    }

    @Test
    @DisplayName("customer를 등록합니다.")
    @Order(1)
    void insertCustomer () throws SQLException {
        int count = dao.insertCustomer("cust02", "이연어");
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("sushi log를 등록합니다.")
    @Order(2)
    void insertSushiLog () throws SQLException {
        int count = dao.insertSushiLog("cust01", "red");
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("고객의 접시 기록을 콘솔에 출력한다")
    @Order(3)
    void testPrintSushiLogByCustomer () throws SQLException {
        dao.printSushiLogByCustomer("cust01");
    }
}