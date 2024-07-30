/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.ChucVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class ChucVuDAO extends MainDAO<ChucVu, Integer> {

    @Override
    public void insert(ChucVu entity) {
        String sql = "INSERT INTO CHUCVU (ID, TenCV) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaCV(),
                entity.getTenCV());
    }

    @Override
    public void update(ChucVu entity) {
        String sql = "UPDATE CHUCVU SET TenCV=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenCV(),
                entity.getMaCV());
    }

    @Override
    public void delete(Integer MaCV) {
        String sql = "DELETE FROM CHUCVU WHERE ID=?";
        JdbcHelper.executeUpdate(sql, MaCV);
    }

    @Override
    public ChucVu findById(Integer MaCV) {
        String sql = "SELECT * FROM CHUCVU WHERE ID=?";
        List<ChucVu> list = selectBySql(sql, MaCV);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ChucVu> select() {
        String sql = "SELECT * FROM CHUCVU";
        return selectBySql(sql);
    }

    @Override
    protected List<ChucVu> selectBySql(String sql, Object... args) {
        List<ChucVu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChucVu entity = new ChucVu();
                    entity.setMaCV(rs.getInt("ID"));
                    entity.setTenCV(rs.getString("TenCV"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }
}

