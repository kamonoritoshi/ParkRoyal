/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.LuongCT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class LuongCTDAO{

    public void insert(LuongCT entity) {
        String sql = "INSERT INTO LUONGCT (HeSoPhuCap, NgayHieuLuc, NhanVienID, LuongID) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getHeSoPhuCap(),
                entity.getNgayHieuLuc(),
                entity.getMaNV(),
                entity.getMaLuong());
    }

    public void update(LuongCT entity) {
        String sql = "UPDATE LUONGCT SET HeSoPhuCap=?, NgayHieuLuc=? WHERE NhanVienID=? AND LuongID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getHeSoPhuCap(),
                entity.getNgayHieuLuc(),
                entity.getMaNV(),
                entity.getMaLuong());
    }

    public void delete(Integer maNV, Integer maLuong) {
        String sql = "DELETE FROM LUONGCT WHERE NhanVienID=? AND LuongID=?";
        JdbcHelper.executeUpdate(sql, maNV, maLuong);
    }

    public LuongCT findById(Integer maNV, Integer maLuong) {
        String sql = "SELECT * FROM LUONGCT WHERE NhanVienID=? AND LuongID=?";
        List<LuongCT> list = selectBySql(sql, maNV, maLuong);
        return list.size()>0 ? list.get(0) : null;
    }

    public List<LuongCT> select() {
        String sql = "SELECT * FROM LUONGCT";
        return selectBySql(sql);
    }

    protected List<LuongCT> selectBySql(String sql, Object... args) {
        List<LuongCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    LuongCT entity = new LuongCT();
                    entity.setHeSoPhuCap(rs.getDouble("HeSoPhuCap"));
                    entity.setNgayHieuLuc(rs.getDate("NgayHieuLuc"));
                    entity.setMaNV(rs.getInt("NhanVienID"));
                    entity.setMaLuong(rs.getInt("LuongID"));
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
