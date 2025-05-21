package org.scoula.smartSushi.dao;

import org.junit.jupiter.api.*;
import org.scoula.smartSushi.common.JDBCUtil;
import org.scoula.smartSushi.domain.SushiLogStat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiFlowTest {
    SushiDao dao = new SushiDaoImpl();

    @BeforeAll
    static void clearBeforeStart () throws SQLException {
        Connection conn = JDBCUtil.getConnection();

        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        System.out.println("\uD83E\uDDF9 [BeforeAll] 전체 테이블 초기화 완료");
    }

    @AfterAll
    static void tearDown () {
        System.out.println("✅ [AfterAll] 모든 테스트 종료!");
    }

    @Test
    @Order(1)
    void insertSampleData () throws SQLException {
        int count = dao.insertCustomer("cust01", "김초밥");
        count += dao.insertSushiLog("cust01", "red");
        count += dao.insertSushiLog("cust01", "blue");
        count += dao.insertSushiLog("cust01", "gold");
        Assertions.assertEquals(4, count);

        System.out.println("\uD83D\uDCCC [1단계] 샘플 데이터 삽입 완료.");
    }

    @Test
    @Order(2)
    void printFavoriteColor () throws SQLException {
        Optional<SushiLogStat> stat = dao.findFavoriteColor("cust01");
        if (stat.isPresent()) {
            System.out.println("\uD83D\uDCCC [2단계] cust01 고객님의 " + stat.get());
        } else {
            System.out.println("⚠\uFE0F 접시 기록이 없어 분석할 수 없습니다.");
        }
    }

    @Test
    @Order(3)
    void resetData () throws SQLException {
        Connection conn = JDBCUtil.getConnection();

        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        System.out.println("\uD83D\uDCCC [3단계] 모든 고객 및 기록이 삭제되었습니다.");
    }

    @Test
    @Order(4)
    void insertMultipleCustomers () throws SQLException {
        int count = dao.insertCustomer("cust02", "이연어");
        count += dao.insertCustomer("cust03", "박광어");
        count += dao.insertSushiLog("cust02", "blue");
        count += dao.insertSushiLog("cust02", "blue");
        count += dao.insertSushiLog("cust02", "gold");
        count += dao.insertSushiLog("cust03", "red");
        count += dao.insertSushiLog("cust03", "gold");
        count += dao.insertSushiLog("cust03", "gold");
        Assertions.assertEquals(8, count);

        System.out.println("\uD83D\uDCCC [4단계] 다중 고객 데이터 삽입 완료.");
    }

    @Test
    @Order(5)
    void printAllStats () throws SQLException {
        List<String> result = dao.getAllCustomerIds();
        System.out.println("\uD83D\uDCCC [5단계] 전체 고객의 최애 접시 색상 통계: ");
        System.out.println("- " + result.get(0));
        System.out.println("- " + result.get(1));
    }
}