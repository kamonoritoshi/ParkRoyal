/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.HocVan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class HocVanDAO extends MainDAO<HocVan, Integer>{

    @Override
    public void insert(HocVan entity) {
        String sql = "INSERT INTO HOCVAN (ID, LoaiCC, MoTa, NgayCap, HieuLuc, NhanVienID) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHV(),
                entity.getLoaiCC(),
                entity.getMoTa(),
                entity.getNgayCap(),
                entity.getHieuLuc(),
                entity.getMaNV());
    }

    @Override
    public void update(HocVan entity) {
        String sql = "UPDATE HOCVAN SET LoaiCC=?, MoTa=?, NgayCap=?, HieuLuc=?, NhanVienID=? WHERE ID=?";
        JdbcHelper.executeUpdate(sql,
                entity.getLoaiCC(),
                entity.getMoTa(),
                entity.getNgayCap(),
                entity.getHieuLuc(),
                entity.getMaNV(),
                entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM HOCVAN WHERE ID=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public HocVan findById(Integer id) {
        String sql = "SELECT * FROM HOCVAN WHERE ID=?";
        List<HocVan> list = selectBySql(sql, id);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<HocVan> select() {
        String sql = "SELECT * FROM HOCVAN";
        return selectBySql(sql);
    }

    @Override
    protected List<HocVan> selectBySql(String sql, Object... args) {
        List<HocVan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()) {
                    HocVan entity = new HocVan();
                    entity.setMaHV(rs.getInt("ID"));
                    entity.setLoaiCC(rs.getString("LoaiCC"));
                    entity.setMoTa(rs.getString("MoTa"));
                    entity.setNgayCap(rs.getDate("NgayCap"));
                    entity.setHieuLuc(rs.getString("HieuLuc"));
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
