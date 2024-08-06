/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.model;

/**
 *
 * @author HIEU HIEU
 */
public class Luong {
    private int maLuong;
    private double luongCoBan;

    @Override
    public String toString() {
        return String.valueOf(maLuong) + " - " + String.valueOf(luongCoBan);
    }

    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
}
