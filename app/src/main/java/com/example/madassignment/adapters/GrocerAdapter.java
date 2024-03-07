package com.example.madassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.madassignment.models.Product;
import com.example.madassignment.R;

import java.text.DecimalFormat;
import java.util.List;

public class GrocerAdapter extends ArrayAdapter<Product> {

    public GrocerAdapter(Context context, List<Product> productList) {
        super(context, 0, productList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grocer_list, parent, false);
        }
        TextView tvGrocer = convertView.findViewById(R.id.tvGrocer);
        TextView tvPrice = convertView.findViewById(R.id.tvPrice);
        tvGrocer.setText(product.getGrocer());

        DecimalFormat df = new DecimalFormat("0.00");
        String price = df.format(product.getPrice());
        tvPrice.setText("RM " +price);

        return convertView;
    }
}
