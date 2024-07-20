/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.TuyenDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class TuyenDungDAO extends MainDAO<TuyenDung, Integer>{

    @Override
    public void insert(TuyenDung entity) {
        String sql = "INSERT INTO TUYENDUNG (ID, HoTenUV, GioiTinh, NgaySinh, NgayNopHS) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaTD(),
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getNgaySinh(),
                entity.getNgayNopHS());
    }

    @Override
    public void update(TuyenDung entity) {
        String sql = "UPDATE TUYENDUNG SET HoTenUV=?, GioiTinh=?, NgaySinh=?, NgayNopHS=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getNgaySinh(),
                entity.getNgayNopHS(),
                entity.getMaTD());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM TUYENDUNG WHERE ID=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public TuyenDung findById(Integer id) {
        String sql = "SELECT * FROM TUYENDUNG WHERE ID=?";
        List<TuyenDung> list = selectBySql(sql, id);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<TuyenDung> select() {
        String sql = "SELECT * FROM TUYENDUNG";
        return selectBySql(sql);
    }

    @Override
    protected List<TuyenDung> selectBySql(String sql, Object... args) {
        List<TuyenDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    TuyenDung entity = new TuyenDung();
                    entity.setMaTD(rs.getInt("ID"));
                    entity.setHoTen(rs.getString("HoTenUV"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setNgaySinh(rs.getDate("NgaySinh"));
                    entity.setNgayNopHS(rs.getDate("NgayNopHS"));
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
