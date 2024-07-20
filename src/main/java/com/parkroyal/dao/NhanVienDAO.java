/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class NhanVienDAO extends MainDAO<NhanVien, Integer>{

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NHANVIEN (ID, HoTen, GioiTinh, NgaySinh, DiaChi, QueQuan, DanToc, SoDT, PhongBanID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, 
                entity.getMaNV(),
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getQueQuan(),
                entity.getDanToc(),
                entity.getSoDT(),
                entity.getMaPB());
    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE NHANVIEN SET HoTen=?, GioiTinh=?, NgaySinh=?, Diachi=?, QueQuan=?, DanToc=?, SoDT=?, PhongBanID=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getQueQuan(),
                entity.getDanToc(),
                entity.getSoDT(),
                entity.getMaPB(),
                entity.getMaNV());
    }

    @Override
    public void delete(Integer MaNV) {
        String sql = "DELETE FROM NHANVIEN WHERE ID=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    @Override
    public NhanVien findById(Integer MaNV) {
        String sql = "SELECT * FROM NHANVIEN WHERE ID=?";
        List<NhanVien> list = selectBySql(sql, MaNV);
        return list.size()>0 ? list.get(0) : null;
    }
    
    public NhanVien findByHoTen(String HoTen) {
        String sql = "SELECT * FROM NHANVIEN WHERE HoTen LIKE ?";
        List<NhanVien> list = selectBySql(sql, HoTen);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> select() {
        String sql = "SELECT * FROM NHANVIEN";
        return selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getInt("ID"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setNgaySinh(rs.getDate("NgaySinh"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setQueQuan(rs.getString("QueQuan"));
                    entity.setDanToc(rs.getString("DanToc"));
                    entity.setSoDT(rs.getString("SoDT"));
                    entity.setMaPB(rs.getInt("PhongBanID"));
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
