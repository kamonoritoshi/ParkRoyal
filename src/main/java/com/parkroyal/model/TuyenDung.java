/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.model;

import java.util.Date;

/**
 *
 * @author HIEU HIEU
 */
public class TuyenDung {
    private int maTD;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private Date ngayNopHS;

    @Override
    public String toString() {
        return String.valueOf(maTD) + " - " + String.valueOf(hoTen);
    }

    
    
    public int getMaTD() {
        return maTD;
    }

    public void setMaTD(int maTD) {
        this.maTD = maTD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayNopHS() {
        return ngayNopHS;
    }

    public void setNgayNopHS(Date ngayNopHS) {
        this.ngayNopHS = ngayNopHS;
    }
    
}
