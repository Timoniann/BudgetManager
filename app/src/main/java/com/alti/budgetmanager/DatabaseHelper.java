package com.alti.budgetmanager;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public DatabaseHelper(Context content){
        super(content, "budget_manager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion){
        try{
            TableUtils.dropTable(connectionSource, Product.class, true);
            TableUtils.createTable(connectionSource, Product.class);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static final Class<?>[] CLASS_LIST = new Class<?>[]{
            Product.class
    };
    public void resetAllTables() throws SQLException{
        for (Class<?> clazz : CLASS_LIST){
            TableUtils.dropTable(connectionSource, clazz, true);
            TableUtils.createTable(connectionSource, clazz);
        }
    }
}