package com.example.madassignment.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.CustomAdapter;
import com.example.madassignment.models.Product;

import java.util.ArrayList;

public class PriceComparisonFragment extends Fragment implements CustomAdapter.ProductClickListener {

    // Fragment params
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    // Views
    RecyclerView recyclerViewProducts;
    SearchView searchBar;
    CustomAdapter customAdapter;
    LinearLayout freshGoods, dryGoods, canGoods, dairyGoods;

    // Database Helpers
    DBHelper db;
    ArrayList<Product> productList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View masterView = inflater.inflate(R.layout.fragment_price_comparison, container, false);

        db = new DBHelper(masterView.getContext());
        recyclerViewProducts = masterView.findViewById(R.id.recyclerViewProducts);
        searchBar = masterView.findViewById(R.id.searchBar);
        freshGoods = masterView.findViewById(R.id.freshGoodsPanel);
        dryGoods = masterView.findViewById(R.id.dryGoodsPanel);
        canGoods = masterView.findViewById(R.id.canGoodsPanel);
        dairyGoods = masterView.findViewById(R.id.dairyGoodsPanel);

        productList = db.getUniqueProducts();
        prepareRecyclerView(masterView);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        freshGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory(view, "Fresh Goods");
            }
        });

        dryGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory(view, "Dry Goods");
            }
        });

        canGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory(view, "Canned Goods");
            }
        });

        dairyGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory(view, "Dairy Goods");
            }
        });

        return masterView;
    }

    public void setCategory(View view, String category) {
        SelectedCategoryFragment selectedCategoryFragment = new SelectedCategoryFragment();
        Bundle data = new Bundle();
        data.putString("productType", category);
        selectedCategoryFragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, selectedCategoryFragment, "findSelectedCategoryFragment")
                .addToBackStack(null)
                .commit();
    }

    public void prepareRecyclerView(View masterView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(masterView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProducts.setLayoutManager(linearLayoutManager);
        prepareAdapter(masterView);
    }

    public void prepareAdapter(View masterView) {
        customAdapter = new CustomAdapter(productList, masterView.getContext(), this::selectedProduct);
        recyclerViewProducts.setAdapter(customAdapter);
    }

    @Override
    public void selectedProduct(Product product, View masterView) {
        SelectedProductFragment selectedProductFragment = new SelectedProductFragment();
        Bundle data = new Bundle();
        data.putSerializable("Product", product);
        selectedProductFragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, selectedProductFragment, "findSelectedProductFragment")
                .addToBackStack(null)
                .commit();
    }

    private void filter(String newText) {
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(p);
            }
        }
        customAdapter.filterList(filteredList);
    }

    public PriceComparisonFragment() {
    }

    public static PriceComparisonFragment newInstance(String param1, String param2) {
        PriceComparisonFragment fragment = new PriceComparisonFragment();
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