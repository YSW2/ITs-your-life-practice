package org.scoula.smartSushi.dao;

import org.scoula.smartSushi.common.JDBCUtil;
import org.scoula.smartSushi.domain.SushiLogStat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SushiDaoImpl implements SushiDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public int insertCustomer (String id, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into customer values (?, ?)"
        )) {
            ps.setString(1, id);
            ps.setString(2, name);
            return ps.executeUpdate();
        }
    }

    @Override
    public int insertSushiLog (String customerId, String plateColor) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into sushi_log values (NULL, ?, ?, DEFAULT)"
        )) {
            ps.setString(1, customerId);
            ps.setString(2, plateColor);
            return ps.executeUpdate();
        }
    }

    @Override
    public void printSushiLogByCustomer (String customerId) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "select plate_color, eaten_at from sushi_log where customer_id = ? order by eaten_at desc"
        )) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("plate_color") + " " + rs.getString("eaten_at"));
            }
        }
    }

    @Override
    public Optional<SushiLogStat> findFavoriteColor (String customerId) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "select plate_color, count(*) as count from sushi_log where customer_id = ? group by plate_color order by count(*) desc limit 1"
        )) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return Optional.of(new SushiLogStat(rs.getString("plate_color"), rs.getInt("count")));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<String> getAllCustomerIds () throws SQLException {
        List<String> list = new ArrayList<>();

        for (int i = 2; i <= 3; i++) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select plate_color, count(*) as count from sushi_log where customer_id = ? group by plate_color order by count(*) desc limit 1"
            )) {
                ps.setString(1, "cust0" + i);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    list.add("cust0" + i + " 님의 " + new SushiLogStat(rs.getString("plate_color"), rs.getInt("count")).toString());
                }
            }
        }
        return list;
    }
}
