package com.example.madassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.models.Deal;
import com.example.madassignment.R;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealAdapterVh> {

    public List<Deal> dealList = new ArrayList<>();
    public Context context;
    public DealClickListener dealClickListener;

    public interface DealClickListener {
        void selectedDeal(Deal deal, View masterView);
    }

    public DealAdapter(List<Deal> dealList, Context c, DealClickListener dealClickListener) {
        this.dealList = dealList;
        this.context = c;
        this.dealClickListener = dealClickListener;
    }

    @NonNull
    @Override
    public DealAdapter.DealAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_deals, parent, false);
        return new DealAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealAdapter.DealAdapterVh holder, int position) {

        Deal deal = dealList.get(position);
        String dealText = deal.getDealText();
        String dealLink = deal.getDealLink();

        holder.dealText.setText(dealText);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dealClickListener.selectedDeal(deal, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }

    public void filterList(List<Deal> filteredList) {
        dealList = filteredList;
        notifyDataSetChanged();
    }

    public static class DealAdapterVh extends RecyclerView.ViewHolder {

        private TextView dealText;

        public DealAdapterVh(@NonNull View itemView) {
            super(itemView);
            dealText = itemView.findViewById(R.id.tvDeal);
        }
    }
}
