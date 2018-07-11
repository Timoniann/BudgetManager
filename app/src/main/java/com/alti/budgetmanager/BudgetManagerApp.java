package com.alti.budgetmanager;

import android.app.Application;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class BudgetManagerApp extends Application {

    private static final String TAG = "BudgetMangerApplication";
    private DatabaseHelper dbHelper;
    private ProductsManager productsManager = null;

    @Override
    public void onCreate() {
        super.onCreate();

        dbHelper = new DatabaseHelper(this);


        /* If you want to reset database */
//        try {
//            dbHelper.resetAllTables();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        getProductsManager();

        // Setup default data to products table
        if (productsManager.count() <= 0) {
            productsManager.add(new Product("Milk", "Milk is good for...", 10));
            productsManager.add(new Product("Flour", "Simple flour", 25));
            productsManager.add(new Product("Potato", "The potato is a starchy, tuberous crop from the perennial nightshade Solanum tuberosum. ", 13));
            productsManager.add(new Product("Buckwheat", "Buckwheat (Fagopyrum esculentum), also known as common buckwheat, Japanese buckwheat and silverhull buckwheat,[2] is a plant cultivated for its grain-like seeds and as a cover crop.", 25));
        }
    }

    public ProductsManager getProductsManager() {
        if (productsManager == null) {
            try {
                Dao<Product, Integer> dao = DaoManager.createDao(dbHelper.getConnectionSource(), Product.class);
                productsManager = new ProductsManager(dao);
            } catch (SQLException e) {
                Log.e(TAG, "getProductsManager error: ", e);
            }
        }
        return productsManager;
    }
}
