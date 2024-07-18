/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.PhongBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class PhongBanDAO extends MainDAO<PhongBan, Integer> {

    @Override
    public void insert(PhongBan entity) {
        String sql = "INSERT INTO PHONGBAN (ID, TenPB, DiaChi, SDT) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaPB(),
                entity.getTenPB(),
                entity.getDiaChi(),
                entity.getSoDT());
    }

    @Override
    public void update(PhongBan entity) {
        String sql = "UPDATE PHONGBAN SET TenPB=?, DiaChi=?, SDT=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenPB(),
                entity.getDiaChi(),
                entity.getSoDT(),
                entity.getMaPB());
    }

    @Override
    public void delete(Integer MaPB) {
        String sql = "DELETE FROM PHONGBAN WHERE ID=?";
        JdbcHelper.executeUpdate(sql, MaPB);
    }

    @Override
    public PhongBan findById(Integer MaPB) {
        String sql = "SELECT * FROM PHONGBAN WHERE ID=?";
        List<PhongBan> list = selectBySql(sql, MaPB);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<PhongBan> select() {
        String sql = "SELECT * FROM PHONGBAN";
        return selectBySql(sql);
    }

    @Override
    protected List<PhongBan> selectBySql(String sql, Object... args) {
        List<PhongBan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhongBan entity = new PhongBan();
                    entity.setMaPB(rs.getInt("ID"));
                    entity.setTenPB(rs.getString("TenPB"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setSoDT(rs.getString("SDT"));
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
