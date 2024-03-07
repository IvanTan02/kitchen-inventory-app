package com.example.madassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;
import com.example.madassignment.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeAdapterVh> {

    public List<Recipe> recipeList = new ArrayList<>();
    public Context context;
    public RecipeClickListener recipeClickListener;

    public interface RecipeClickListener {
        void selectedRecipe(Recipe recipe, View masterView);
    }

    public RecipeAdapter (List<Recipe> recipeList, Context c, RecipeClickListener recipeClickListener) {
        this.recipeList = recipeList;
        this.context = c;
        this.recipeClickListener = recipeClickListener;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_recipe, parent, false);
        return new RecipeAdapter.RecipeAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeAdapterVh holder, int position) {
        Recipe recipe = recipeList.get(position);

        holder.dishName.setText(recipe.getDishesname());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeClickListener.selectedRecipe(recipe, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void filterList(List<Recipe> filteredList) {
        recipeList = filteredList;
        notifyDataSetChanged();
    }

    public static class RecipeAdapterVh extends RecyclerView.ViewHolder {

        private TextView dishName;

        public RecipeAdapterVh(@NonNull View itemView) {
            super(itemView);
            dishName = itemView.findViewById(R.id.tvRecipeName);
        }
    }
}