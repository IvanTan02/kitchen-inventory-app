package com.example.madassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.ItemAdapter;

import java.util.ArrayList;

public class InventoryFragment extends Fragment implements ItemAdapter.ItemClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    ArrayList<String> itemList = new ArrayList<>();
    ArrayList<String> itemDetails = new ArrayList<>();
    Button btAdd;
    SearchView searchBar;

    DBHelper databaseHelper;
    RecyclerView itemView;
    ItemAdapter itemAdapter;

    public InventoryFragment() {
    }

    public static InventoryFragment newInstance(String param1, String param2) {
        InventoryFragment fragment = new InventoryFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inventory, container, false);
        btAdd = rootView.findViewById(R.id.bt_add);
        searchBar= rootView.findViewById(R.id.search_bar);
        itemView = rootView.findViewById(R.id.item_list);

        databaseHelper = new DBHelper(rootView.getContext());

        itemList = databaseHelper.getItemNames();
        System.out.println(itemList);
        prepareRecyclerView(rootView);


        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                filter(query);
                return true;
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFragment addFragment = new AddFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, addFragment, "addFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return rootView;
    }

    public void prepareRecyclerView(View rootView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        itemView.setLayoutManager(linearLayoutManager);
        prepareAdapter(rootView);
    }

    public void prepareAdapter(View rootView) {
        itemAdapter = new ItemAdapter(itemList, rootView.getContext(), this::selectedItem);
        itemView.setAdapter(itemAdapter);
    }

    @Override
    public void selectedItem(String itemName, View rootView) {

        SelectedItemFragment detailActivity = new SelectedItemFragment();
        Bundle data = new Bundle();
        data.putString("ItemName", itemName);
        detailActivity.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, detailActivity, "detailActivity")
                .addToBackStack(null)
                .commit();
    }

    private void filter(String query) {
        ArrayList<String> filteredList = new ArrayList<>();
        for (String s : itemList) {
            if (s.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(s);
            }
        }
        itemAdapter.filterList(filteredList);
    }

}