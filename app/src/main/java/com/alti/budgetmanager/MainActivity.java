package com.alti.budgetmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting productsManager from application
        BudgetManagerApp app = (BudgetManagerApp)getApplicationContext();
        ProductsManager productsManager = app.getProductsManager();

        // And putting all products into the listView adapter
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new ListAdapter(this, productsManager.getAll()));
    }
}
