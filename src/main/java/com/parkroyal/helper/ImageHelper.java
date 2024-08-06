/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkroyal.helper;

import com.parkroyal.model.NhanVien;
import java.io.IOException;
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

    // Lưu hình ảnh từ đường dẫn bất kỳ
    public static void save(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Đọc hình ảnh từ đường dẫn bất kỳ
    public static ImageIcon read(String fileName) {
        return new ImageIcon(fileName);
    }

    // Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static NhanVien USER = null;

    // Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void logoff() {
        ImageHelper.USER = null;
    }

    // Kiểm tra xem đăng nhập hay chưa
    public static boolean authenticated() {
        return ImageHelper.USER != null;
    }
}


