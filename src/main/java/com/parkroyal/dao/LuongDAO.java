/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.Luong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class LuongDAO extends MainDAO<Luong, Integer>{

    @Override
    public void insert(Luong entity) {
        String sql = "INSERT INTO LUONG (ID, LuongCoBan, BacLuong, HeSoLuong, HeSoPhuCap, NhanVienID) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLuong(),
                entity.getLuongCoBan(),
                entity.getBacLuong(),
                entity.getHeSoLuong(),
                entity.getHeSoPhuCap(),
                entity.getMaNV());
    }

    @Override
    public void update(Luong entity) {
        String sql = "UPDATE LUONG SET LuongCoBan=?, BacLuong=?, HeSoLuong=?, HeSoPhuCap=?, NhanVienID=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getLuongCoBan(),
                entity.getBacLuong(),
                entity.getHeSoLuong(),
                entity.getHeSoPhuCap(),
                entity.getMaNV(),
                entity.getMaLuong());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM LUONG WHERE ID=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public Luong findById(Integer id) {
        String sql = "SELECT * FROM LUONG WHERE ID=?";
        List<Luong> list = selectBySql(sql, id);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<Luong> select() {
        String sql = "SELECT * FROM LUONG";
        return selectBySql(sql);
    }

    @Override
    protected List<Luong> selectBySql(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    Luong entity = new Luong();
                    entity.setMaLuong(rs.getInt("ID"));
                    entity.setLuongCoBan(rs.getDouble("LuongCoBan"));
                    entity.setBacLuong(rs.getDouble("BacLuong"));
                    entity.setHeSoLuong(rs.getDouble("HeSoLuong"));
                    entity.setHeSoPhuCap(rs.getDouble("HeSoPhuCap"));
                    entity.setMaNV(rs.getInt("NhanVienID"));
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
