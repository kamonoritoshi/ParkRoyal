/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.PhongVan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class PhongVanDAO {

    public void insert(PhongVan entity) {
        String sql = "INSERT INTO PHONGVAN (NgayPV, TrangThai, ChucVuID, TuyenDungID) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayPV(),
                entity.isTrangThai(),
                entity.getMaCV(),
                entity.getMaTD());
    }

    public void update(PhongVan entity) {
        String sql = "UPDATE PHONGVAN SET NgayPV=?, TrangThai=? WHERE ChucVuID=? AND TuyenDungID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayPV(),
                entity.isTrangThai(),
                entity.getMaCV(),
                entity.getMaTD());
    }

    public void delete(Integer MaCV, Integer MaTD) {
        String sql = "DELETE FROM PHONGVAN WHERE ChucVuID=? AND TuyenDungID=?";
        JdbcHelper.executeUpdate(sql, MaCV, MaTD);
    }

    public PhongVan findById(Integer MaCV, Integer MaTD) {
        String sql = "SELECT * FROM PHONGVAN WHERE ChucVuID=? AND TuyenDungID=?";
        List<PhongVan> list = selectBySql(sql, MaCV, MaTD);
        return list.size()>0 ? list.get(0) : null;
    }

    public List<PhongVan> select() {
        String sql = "SELECT * FROM PHONGVAN";
        return selectBySql(sql);
    }

    protected List<PhongVan> selectBySql(String sql, Object... args) {
        List<PhongVan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    PhongVan entity = new PhongVan();
                    entity.setNgayPV(rs.getDate("NgayPV"));
                    entity.setTrangThai(rs.getBoolean("TrangThai"));
                    entity.setMaCV(rs.getInt("ChucVuID"));
                    entity.setMaTD(rs.getInt("TuyenDungID"));
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
