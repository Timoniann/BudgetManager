package com.alti.budgetmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Product> data;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context, List<Product> products){
        data = products;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = layoutInflater.inflate(R.layout.list_item, parent, false);
        }

        Product currentItem = data.get(position);

        TextView titleView = vi.findViewById(R.id.text_view_title);
        TextView descriptionView = vi.findViewById(R.id.text_view_description);
        TextView costsView = vi.findViewById(R.id.test_view_costs);

        titleView.setText(currentItem.getTitle());
        descriptionView.setText(currentItem.getDescription());
        costsView.setText(((Object)currentItem.getCosts()).toString());

        return vi;
    }
}
