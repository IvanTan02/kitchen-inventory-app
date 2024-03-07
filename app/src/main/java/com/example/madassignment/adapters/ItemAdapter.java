package com.example.madassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.example.madassignment.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterVh> {


    public List<String> itemNameList = new ArrayList<>();
    public Context context;
    public ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void selectedItem(String itemName, View masterView);
    }

    public ItemAdapter (List<String> itemList, Context c,ItemClickListener itemClickListener) {
        this.itemNameList = itemList;
        this.context = c;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_cell, parent, false);
        return new ItemAdapter.ItemAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemAdapterVh holder, int position) {
        String name = itemNameList.get(position);

        holder.itemName.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.selectedItem(name, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemNameList.size();
    }

    public void filterList(List<String> filteredList) {
        itemNameList = filteredList;
        notifyDataSetChanged();
    }

    public static class ItemAdapterVh extends RecyclerView.ViewHolder {

        private TextView itemName;

        public ItemAdapterVh(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);


        }
    }
}