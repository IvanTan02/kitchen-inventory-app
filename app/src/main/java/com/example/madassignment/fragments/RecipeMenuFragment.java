package com.example.madassignment.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.RecipeAdapter;
import com.example.madassignment.models.Recipe;

import java.util.ArrayList;


public class RecipeMenuFragment extends Fragment implements RecipeAdapter.RecipeClickListener{

    RecyclerView recipeView;
    DBHelper db;
    ArrayList<Recipe> recipesList = new ArrayList<>();
    RecipeAdapter recipeAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_menu, container, false);
        recipeView = view.findViewById(R.id.recipeView);
        db = new DBHelper(view.getContext());
        recipesList = db.getRecipes();
        prepareRecyclerView(view);

        // Inflate the layout for this fragment
        return view;
    }

    public void prepareRecyclerView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recipeView.setLayoutManager(linearLayoutManager);
        prepareAdapter(view);
    }

    public void prepareAdapter(View masterView) {
        recipeAdapter = new RecipeAdapter(recipesList, masterView.getContext(), this::selectedRecipe);
        recipeView.setAdapter(recipeAdapter);
    }

    @Override
    public void selectedRecipe(Recipe recipe, View view) {
        RecipeContentFragment recipeContentFragment = new RecipeContentFragment();
        Bundle data = new Bundle();
        data.putSerializable("Recipe", recipe);
        recipeContentFragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, recipeContentFragment, "findSelectedProductFragment")
                .addToBackStack(null)
                .commit();
    }

    public RecipeMenuFragment() {
        // Required empty public constructor
    }

    public static RecipeMenuFragment newInstance(String param1, String param2) {
        RecipeMenuFragment  fragment = new RecipeMenuFragment();
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
