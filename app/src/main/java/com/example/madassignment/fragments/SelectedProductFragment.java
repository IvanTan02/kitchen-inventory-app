package com.example.madassignment.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.GrocerAdapter;
import com.example.madassignment.models.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SelectedProductFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    TextView tvProductName, tvProductType, tvLowestPrice, tvHighestPrice, tvAveragePrice;
    Button backBtn;
    Product product;
    Intent intent;
    GrocerAdapter grocerAdapter;
    ArrayList<Product> availableGrocers = new ArrayList<>();
    ListView grocerList;

    DBHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View masterView = inflater.inflate(R.layout.fragment_selected_product, container, false);

        db = new DBHelper(masterView.getContext());
        tvProductName = masterView.findViewById(R.id.tvProductName);
        tvProductType = masterView.findViewById(R.id.tvProductType);
        tvLowestPrice = masterView.findViewById(R.id.tvLowestPrice);
        tvHighestPrice = masterView.findViewById(R.id.tvHighestPrice);
        tvAveragePrice = masterView.findViewById(R.id.tvAvgPrice);
        grocerList = masterView.findViewById(R.id.grocerList);
        backBtn = masterView.findViewById(R.id.backBtn);
        intent = getActivity().getIntent();

        if (intent != null) {
            product = (Product) getArguments().getSerializable("Product");
            String productName = product.getProductName();
            String productType = product.getProductType();
            tvProductName.setText(productName);
            tvProductType.setText(productType);

            DecimalFormat df = new DecimalFormat("0.00");
            String highestPrice = "RM " + df.format(db.getHighestPrice(productName, productType));
            tvHighestPrice.setText(highestPrice);

            String lowestPrice = "RM " + df.format(db.getLowestPrice(productName, productType));
            tvLowestPrice.setText(lowestPrice);

            String avgPrice = "RM " + df.format(db.getAveragePrice(productName, productType));
            tvAveragePrice.setText(avgPrice);

            availableGrocers = db.getGrocerList(productName, productType);
            grocerAdapter = new GrocerAdapter(masterView.getContext(), availableGrocers);
            grocerList.setAdapter(grocerAdapter);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return masterView;
    }

    public SelectedProductFragment() {
    }

    public static SelectedProductFragment newInstance(String param1, String param2) {
        SelectedProductFragment fragment = new SelectedProductFragment();
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