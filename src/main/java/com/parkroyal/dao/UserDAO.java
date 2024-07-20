/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import com.parkroyal.helper.JdbcHelper;
import com.parkroyal.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU HIEU
 */
public class UserDAO {
   
    public void insert(User model) {
        String sql = "INSERT INTO USER (Username, Password, FullName, Email, Role) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getUsername(),
                model.getPassword(),
                model.getFullName(),
                model.getEmail(),
                model.isRole());
    }
    
    public void update(User model) {
        String sql = "UPDATE USEr SET Password=?, FullName=?, Email=?, Role=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,
                model.getPassword(),
                model.getFullName(),
                model.getEmail(),
                model.isRole(),
                model.getUsername());
    }
    
    public void delete(String Username) {
        String sql = "DELETE FROM USER WHERE Username=?";
        JdbcHelper.executeUpdate(sql, Username);
    }
    
    public User findById(String Username) {
        String sql = "SELECT * FROM USER WHERE Username = ?";
        List<User> list = select(sql, Username);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private List<User> select(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    User model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    private User readFromResultSet(ResultSet rs) throws SQLException {
        User model = new User();
        model.setUsername(rs.getString("Username"));
        model.setPassword(rs.getString("Password"));
        model.setFullName(rs.getString("FullName"));
        model.setEmail(rs.getString("Email"));
        model.setRole(rs.getBoolean("Role"));
        return model;
    }
    
}
