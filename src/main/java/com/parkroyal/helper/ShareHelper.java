/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.helper;

import com.parkroyal.model.User;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author HIEU HIEU
 */
public class ShareHelper {

    /**
     * Sao chép file ảnh nhân viên vào thư mục logo
     *
     * @param file là đối tượng file ảnh
     * @return chép được hay không
     */
    public static void save(File src) {
        File dir = new File("D:/ParkRoyal/src/main/resources/", src.getName());
        if (!dir.getParentFile().exists()) {
            dir.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dir.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Đọc hình ảnh nhân viên
     *
     * @param fileName là tên file logo
     * @return ảnh đọc được
     */
    public static ImageIcon read(String fileName) {
        File path = new File("D:/ParkRoyal/src/main/resources/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static User USER = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        ShareHelper.USER = null;
    }
    
    /**
     * Kiểm tra xem đăng nhập hay chưa
     *
     * @return đăng nhập hay chưa
     */
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
    
    public static boolean isManager() {
        return ShareHelper.authenticated() && USER.isRole();
    }
}
