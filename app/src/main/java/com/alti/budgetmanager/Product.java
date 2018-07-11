package com.alti.budgetmanager;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "products")
public class Product {

    @DatabaseField(columnName = BaseColumns._ID, generatedId = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private float costs;

    public Product(){
        id = -1;
        title = "Undefined";
        description = "Undefined";
        costs = 0;
    }

    public Product(String title, String description, float costs){
        setTitle(title);
        setDescription(description);
        setCosts(costs);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }
}
