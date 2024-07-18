/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.dao;

import java.util.List;
/**
 *
 * @author HIEU HIEU
 */
abstract public class MainDAO<EntityType, KeyType> {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType findById(KeyType id);
    abstract public List<EntityType> select();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
