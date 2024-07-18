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
public class PhongVan {
    private Date ngayPV;
    private boolean trangThai;
    private int maCV;
    private int maTD;

    public Date getNgayPV() {
        return ngayPV;
    }

    public void setNgayPV(Date ngayPV) {
        this.ngayPV = ngayPV;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public int getMaTD() {
        return maTD;
    }

    public void setMaTD(int maTD) {
        this.maTD = maTD;
    }
    
}
