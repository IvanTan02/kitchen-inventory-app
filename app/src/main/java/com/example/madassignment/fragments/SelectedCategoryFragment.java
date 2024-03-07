package com.example.madassignment.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.CategoryAdapter;
import com.example.madassignment.models.Product;

import java.util.ArrayList;

public class SelectedCategoryFragment extends Fragment implements CategoryAdapter.ProductCatClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    DBHelper db;
    ArrayList<Product> productsInCat = new ArrayList<>();
    RecyclerView viewProducts;
    SearchView searchBar;
    CategoryAdapter catAdapter;
    Intent intent;
    Button backBtn;
    TextView categoryLabel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View masterView = inflater.inflate(R.layout.fragment_selected_category, container, false);

        db = new DBHelper(masterView.getContext());
        viewProducts = masterView.findViewById(R.id.viewProducts);
        searchBar = masterView.findViewById(R.id.searchBar);
        backBtn = masterView.findViewById(R.id.backBtn);
        categoryLabel = masterView.findViewById(R.id.categoryLabel);
        intent = getActivity().getIntent();

        if (intent != null) {
            String category = getArguments().getString("productType");
            categoryLabel.setText("Products in " + category);
            productsInCat = db.getProductsInCat(category);
        }

        prepareViewProducts(masterView);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterCat(newText);
                return true;
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return masterView;
    }

    private void filterCat(String newText) {
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product p : productsInCat) {
            if (p.getProductName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(p);
            }
        }
        catAdapter.filterList(filteredList);
    }

    public void prepareViewProducts(View masterView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(masterView.getContext(), LinearLayoutManager.VERTICAL, false);
        viewProducts.setLayoutManager(linearLayoutManager);
        prepareCatAdapter(masterView);
    }

    public void prepareCatAdapter(View masterView) {
        catAdapter = new CategoryAdapter(productsInCat, masterView.getContext(), this::selectedProductInCat);
        viewProducts.setAdapter(catAdapter);
    }

    @Override
    public void selectedProductInCat(Product product, View masterView) {
        SelectedProductFragment selectedProductFragment = new SelectedProductFragment();
        Bundle data = new Bundle();
        data.putSerializable("Product", product);
        selectedProductFragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, selectedProductFragment, "findSelectedProductFragment")
                .addToBackStack(null)
                .commit();
    }

    public SelectedCategoryFragment() {
    }

    public static SelectedCategoryFragment newInstance(String param1, String param2) {
        SelectedCategoryFragment fragment = new SelectedCategoryFragment();
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