/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkroyal.helper;

import com.parkroyal.model.NhanVien;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageHelper {

    public static void save(File file) {
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get("D:/ParkRoyal/src/main/resources/" + file.getName());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * * Đọc hình ảnh logo chuyên đề * @param fileName là tên file logo *
     * @param fileName
     * @return ảnh đọc được
     */
    public static ImageIcon read(String fileName) {
        return new ImageIcon(fileName);
    }
    /**
     * * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien USER = null;

    /**
     * * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        ImageHelper.USER = null;
    }

    /**
     * * Kiểm tra xem đăng nhập hay chưa * @return đăng nhập hay chưa
     * @return 
     */
    public static boolean authenticated() {
        return ImageHelper.USER != null;
    }
}


