package com.alti.budgetmanager;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

class ProductsManager {
    private Dao<Product, Integer> dao;

    ProductsManager(Dao<Product, Integer> dao){
        this.dao = dao;
    }

    public List<Product> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            Log.e("ProductsManager", "SQLException", e);
            return Collections.emptyList();
        }
    }

    public void add(Product item){
        try {
            dao.create(item);
        } catch (SQLException e){
            Log.e("ProductsManager", "SQLException", e);
        }
    }

    public long count(){
        try {
            return dao.countOf();
        } catch (SQLException e) {
            Log.e("ProductsManager", "SQLException", e);
            return -1;
        }
    }
}
