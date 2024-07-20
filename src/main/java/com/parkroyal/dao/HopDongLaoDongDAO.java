/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.HopDongLaoDong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class HopDongLaoDongDAO{

    public void insert(HopDongLaoDong entity) {
        String sql = "INSERT INTO HDLD (NgayKy, NgayBDLV, ChucVuID, NhanVienID) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayKy(),
                entity.getNgayBDLV(),
                entity.getMaCV(),
                entity.getMaNV());
    }

    public void update(HopDongLaoDong entity) {
        String sql = "UPDATE HDLD SET NgayKy=?, NgayBDLV=? WHERE ChucVuID=? AND NhanVienID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayKy(),
                entity.getNgayBDLV(),
                entity.getMaCV(),
                entity.getMaNV());
    }

    public void delete(Integer MaCV, Integer MaNV) {
        String sql = "DELETE FROM HDLD WHERE ChucVuID=? AND NhanVienID=?";
        JdbcHelper.executeUpdate(sql, MaCV, MaNV);
    }

    public HopDongLaoDong findById(Integer MaCV, Integer MaNV) {
        String sql = "SELECT * FROM HDLD WHERE ChucVuID=? AND NhanVienID=?";
        List<HopDongLaoDong> list = selectBySql(sql, MaCV, MaNV);
        return list.size()>0 ? list.get(0) : null;
    }

    public List<HopDongLaoDong> select() {
        String sql = "SELECT * FROM HDLD";
        return selectBySql(sql);
    }

    protected List<HopDongLaoDong> selectBySql(String sql, Object... args) {
        List<HopDongLaoDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    HopDongLaoDong entity = new HopDongLaoDong();
                    entity.setNgayKy(rs.getDate("NgayKy"));
                    entity.setNgayBDLV(rs.getDate("NgayBDLV"));
                    entity.setMaCV(rs.getInt("ChucVuID"));
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
