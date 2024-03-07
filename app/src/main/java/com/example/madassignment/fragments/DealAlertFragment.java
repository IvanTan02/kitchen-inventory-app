package com.example.madassignment.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.DealAdapter;
import com.example.madassignment.models.Deal;

import java.util.ArrayList;

public class DealAlertFragment extends Fragment implements DealAdapter.DealClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewDeals;
    DealAdapter dealAdapter;
    DBHelper db;
    ArrayList<Deal> dealList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View masterView = inflater.inflate(R.layout.fragment_deal_alert, container, false);
        db = new DBHelper(masterView.getContext());
        recyclerViewDeals = masterView.findViewById(R.id.recyclerViewDeals);
        dealList = db.getDeals();
        System.out.println(dealList);
        prepareDealsView(masterView);
        return masterView;
    }

    public void prepareDealsView(View masterView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(masterView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewDeals.setLayoutManager(linearLayoutManager);
        prepareAdapter(masterView);
    }

    public void prepareAdapter(View masterView) {
        dealAdapter = new DealAdapter(dealList, masterView.getContext(), this::selectedDeal);
        recyclerViewDeals.setAdapter(dealAdapter);
    }

    @Override
    public void selectedDeal(Deal deal, View masterView) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(deal.getDealLink()));
        startActivity(intent);
    }

    public DealAlertFragment() {}

    public static DealAlertFragment newInstance(String param1, String param2) {
        DealAlertFragment fragment = new DealAlertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

}