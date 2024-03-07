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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomAdapterVh> {

    public List<Product> productList = new ArrayList<>();
    public Context context;
    public ProductClickListener productClickListener;

    public interface ProductClickListener {
        void selectedProduct(Product product, View masterView);
    }

    public CustomAdapter(List<Product> productList, Context c, ProductClickListener productClickListener) {
        this.productList = productList;
        this.context = c;
        this.productClickListener = productClickListener;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_products, parent, false);
        return new CustomAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomAdapterVh holder, int position) {

        Product product = productList.get(position);
        String productName = product.getProductName();
        String productType = product.getProductType();

        holder.productName.setText(productName);
        holder.productType.setText(productType);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productClickListener.selectedProduct(product, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void filterList(List<Product> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }

    public static class CustomAdapterVh extends RecyclerView.ViewHolder {

        private TextView productName;
        private TextView productType;


        public CustomAdapterVh(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tvProductName);
            productType = itemView.findViewById(R.id.tvProductType);
        }
    }
}
