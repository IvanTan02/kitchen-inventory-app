package com.example.madassignment.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.madassignment.R;
import com.example.madassignment.models.Recipe;

public class RecipeContentFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    TextView tvDishName, tvIngredients, tvInstructions;
    Intent intent;
    Recipe recipe;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View masterView = inflater.inflate(R.layout.fragment_recipe_content, container, false);
        tvDishName = masterView.findViewById(R.id.dishName);
        tvIngredients = masterView.findViewById(R.id.ingredients);
        tvInstructions = masterView.findViewById(R.id.instructions);
        intent = getActivity().getIntent();

        if (intent != null) {
            recipe = (Recipe) getArguments().getSerializable("Recipe");
            String dishName = recipe.getDishesname();
            String ingredients = recipe.getIngredients();
            String instructions = recipe.getInstructions();
            tvDishName.setText(dishName);
            tvIngredients.setText(ingredients);
            tvInstructions.setText(instructions);
        }

        return masterView;
    }

    public RecipeContentFragment() {
    }

    public static RecipeContentFragment newInstance(String param1, String param2) {
        RecipeContentFragment fragment = new RecipeContentFragment();
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
