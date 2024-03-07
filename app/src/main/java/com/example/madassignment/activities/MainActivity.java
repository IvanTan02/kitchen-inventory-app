package com.example.madassignment.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.madassignment.fragments.DealAlertFragment;
import com.example.madassignment.fragments.InventoryFragment;
import com.example.madassignment.fragments.PriceComparisonFragment;
import com.example.madassignment.R;
import com.example.madassignment.fragments.RecipeMenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNav;
    PriceComparisonFragment priceComparisonFragment = new PriceComparisonFragment();
    DealAlertFragment dealAlertFragment = new DealAlertFragment();
    InventoryFragment inventoryFragment = new InventoryFragment();
    RecipeMenuFragment recipeMenuFragment = new RecipeMenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bottom_nav_blue)));

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.inventory);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.inventory:
                if (!priceComparisonFragment.isRemoving() || !dealAlertFragment.isRemoving())
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, inventoryFragment).commit();
                return true;

            case R.id.recipe_recommendation:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, recipeMenuFragment).commit();
                return true;

            case R.id.price_comparison:
                if (!inventoryFragment.isRemoving() || !dealAlertFragment.isRemoving())
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, priceComparisonFragment).commit();
                return true;

            case R.id.deal_alert:
                if (!priceComparisonFragment.isRemoving() || !inventoryFragment.isRemoving())
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, dealAlertFragment).commit();
                return true;
        }
        return false;
    }
}