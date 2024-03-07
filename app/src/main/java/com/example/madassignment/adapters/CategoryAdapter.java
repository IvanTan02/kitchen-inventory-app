package com.example.madassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.models.Product;
import com.example.madassignment.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterVh> {

    public List<Product> productsInCat = new ArrayList<>();
    public Context context;
    public ProductCatClickListener productCatClickListener;

    public interface ProductCatClickListener {
        void selectedProductInCat(Product product, View masterView);
    }

    public CategoryAdapter(List<Product> productsInCat, Context c, ProductCatClickListener productCatClickListener) {
        this.productsInCat = productsInCat;
        this.context = c;
        this.productCatClickListener = productCatClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_cat_products, parent, false);
        return new CategoryAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryAdapterVh holder, int position) {

        Product product = productsInCat.get(position);
        String productName = product.getProductName();

        holder.productName.setText(productName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productCatClickListener.selectedProductInCat(product, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsInCat.size();
    }

    public void filterList(List<Product> filteredList) {
        productsInCat = filteredList;
        notifyDataSetChanged();
    }

    public static class CategoryAdapterVh extends RecyclerView.ViewHolder {

        private TextView productName;


        public CategoryAdapterVh(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tvProductName);
        }
    }
}
