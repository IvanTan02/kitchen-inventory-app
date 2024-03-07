package com.example.madassignment.adapters;

import com.example.madassignment.models.Deal;
import com.example.madassignment.models.Item;
import com.example.madassignment.models.Product;
import com.example.madassignment.models.Recipe;
import java.util.ArrayList;

public class ProductAdapter {

    public ArrayList initializeProducts() {
        ArrayList<Product> initProductList = new ArrayList<>();
        // Fresh Goods
        initProductList.add(new Product("500g Chicken Fillet", "Fresh Goods", 11.45, "Jaya Grocer"));
        initProductList.add(new Product("500g Chicken Fillet", "Fresh Goods", 12.50, "AEON"));
        initProductList.add(new Product("500g Chicken Fillet", "Fresh Goods", 11.30, "Econsave"));
        initProductList.add(new Product("Whole Chicken", "Fresh Goods", 19.80, "Jaya Grocer"));
        initProductList.add(new Product("Whole Chicken", "Fresh Goods", 18.80, "AEON"));
        initProductList.add(new Product("Whole Chicken", "Fresh Goods", 18.45, "Econsave"));
        initProductList.add(new Product("500g Local Tomato", "Fresh Goods", 2.50, "Jaya Grocer"));
        initProductList.add(new Product("500g Local Tomato", "Fresh Goods", 2.25, "AEON"));
        initProductList.add(new Product("500g Local Tomato", "Fresh Goods", 2.10, "Econsave"));
        initProductList.add(new Product("500g Holland Potatoes", "Fresh Goods", 1.80, "Jaya Grocer"));
        initProductList.add(new Product("500g Holland Potatoes", "Fresh Goods", 1.70, "AEON"));
        initProductList.add(new Product("500g Holland Potatoes", "Fresh Goods", 1.65, "Econsave"));
        initProductList.add(new Product("South Africa Lemon 6 Pack", "Fresh Goods", 8.50, "Jaya Grocer"));
        initProductList.add(new Product("South Africa Lemon 6 Pack", "Fresh Goods", 8.30, "AEON"));
        initProductList.add(new Product("South Africa Lemon 6 Pack", "Fresh Goods", 8.15, "Econsave"));
        initProductList.add(new Product("Nutriplus Omega-3 Eggs 10x", "Fresh Goods", 8.25, "Jaya Grocer"));
        initProductList.add(new Product("Nutriplus Omega-3 Eggs 10x", "Fresh Goods", 8.10, "AEON"));
        initProductList.add(new Product("Nutriplus Omega-3 Eggs 10x", "Fresh Goods", 7.95, "Econsave"));
        initProductList.add(new Product("Farm Gold Australia Carrots", "Fresh Goods", 2.95, "Jaya Grocer"));
        initProductList.add(new Product("Farm Gold Australia Carrot", "Fresh Goods", 3.05, "AEON"));
        initProductList.add(new Product("Farm Gold Australia Carrot", "Fresh Goods", 2.80, "Econsave"));
        initProductList.add(new Product("1 Bundle Dole Banana", "Fresh Goods", 5.50, "Jaya Grocer"));
        initProductList.add(new Product("1 Bundle Dole Banana", "Fresh Goods", 5.35, "AEON"));
        initProductList.add(new Product("1 Bundle Dole Banana", "Fresh Goods", 5.20, "Econsave"));
        initProductList.add(new Product("~200g Fresh Norwegian Fish Fillet", "Fresh Goods", 28.9, "Jaya Grocer"));
        initProductList.add(new Product("~200g Fresh Norwegian Fish Fillet", "Fresh Goods", 27.5, "AEON"));
        initProductList.add(new Product("~200g Fresh Norwegian Fish Fillet", "Fresh Goods", 26.9, "Econsave"));
        initProductList.add(new Product("Cameron Iceberg Lettuce", "Fresh Goods", 3.2, "Jaya Grocer"));
        initProductList.add(new Product("Cameron Iceberg Lettuce", "Fresh Goods", 3.5, "AEON"));
        initProductList.add(new Product("Cameron Iceberg Lettuce", "Fresh Goods", 2.95, "Econsave"));

        // Dry Goods
        initProductList.add(new Product("Moghul Faize Basmathi Rice", "Dry Goods", 49.0, "Jaya Grocer"));
        initProductList.add(new Product("Moghul Faize Basmathi Rice", "Dry Goods", 48.3, "AEON"));
        initProductList.add(new Product("Moghul Faize Basmathi Rice", "Dry Goods", 47.85, "Econsave"));
        initProductList.add(new Product("Moghul Faize Basmathi Rice", "Dry Goods", 47.30, "99 Speedmart"));
        initProductList.add(new Product("San Remo Vegeroni Spiral", "Dry Goods", 5.50, "Jaya Grocer"));
        initProductList.add(new Product("San Remo Vegeroni Spiral", "Dry Goods", 5.60, "AEON"));
        initProductList.add(new Product("San Remo Vegeroni Spiral", "Dry Goods", 5.35, "Econsave"));
        initProductList.add(new Product("San Remo Vegeroni Spiral", "Dry Goods", 5.30, "99 Speedmart"));
        initProductList.add(new Product("LKK Organic Soy Sauce", "Dry Goods", 15.50, "Jaya Grocer"));
        initProductList.add(new Product("LKK Organic Soy Sauce", "Dry Goods", 15.60, "AEON"));
        initProductList.add(new Product("LKK Organic Soy Sauce", "Dry Goods", 15.35, "Econsave"));
        initProductList.add(new Product("LKK Organic Soy Sauce", "Dry Goods", 15.30, "99 Speedmart"));
        initProductList.add(new Product("Maggi Chicken Stock Cube", "Dry Goods", 3.50, "Jaya Grocer"));
        initProductList.add(new Product("Maggi Chicken Stock Cube", "Dry Goods", 3.60, "AEON"));
        initProductList.add(new Product("Maggi Chicken Stock Cube", "Dry Goods", 3.35, "Econsave"));
        initProductList.add(new Product("Maggi Chicken Stock Cube", "Dry Goods", 3.30, "99 Speedmart"));
        initProductList.add(new Product("Adabi Perencah Bihun Noodles", "Dry Goods", 4.50, "Jaya Grocer"));
        initProductList.add(new Product("Adabi Perencah Bihun Noodles", "Dry Goods", 4.60, "AEON"));
        initProductList.add(new Product("Adabi Perencah Bihun Noodles", "Dry Goods", 4.35, "Econsave"));
        initProductList.add(new Product("Adabi Perencah Bihun Noodles", "Dry Goods", 4.30, "99 Speedmart"));
        initProductList.add(new Product("CED Natural Himalayan Rock Salt", "Dry Goods", 4.80, "Jaya Grocer"));
        initProductList.add(new Product("CED Natural Himalayan Rock Salt", "Dry Goods", 4.90, "AEON"));
        initProductList.add(new Product("CED Natural Himalayan Rock Salt", "Dry Goods", 4.65, "Econsave"));
        initProductList.add(new Product("CED Natural Himalayan Rock Salt", "Dry Goods", 4.60, "99 Speedmart"));
        initProductList.add(new Product("Ajinomoto MSG", "Dry Goods", 8.80, "Jaya Grocer"));
        initProductList.add(new Product("Ajinomoto MSG", "Dry Goods", 8.90, "AEON"));
        initProductList.add(new Product("Ajinomoto MSG", "Dry Goods", 8.65, "Econsave"));
        initProductList.add(new Product("Ajinomoto MSG", "Dry Goods", 8.60, "99 Speedmart"));

        // Canned Goods
        initProductList.add(new Product("Ayam Brand Baked Beans", "Canned Goods", 4.10, "Jaya Grocer"));
        initProductList.add(new Product("Ayam Brand Baked Beans", "Canned Goods", 4.05, "AEON"));
        initProductList.add(new Product("Ayam Brand Baked Beans", "Canned Goods", 3.85, "Econsave"));
        initProductList.add(new Product("Ayam Brand Baked Beans", "Canned Goods", 3.95, "99 Speedmart"));
        initProductList.add(new Product("Ayam Brand Tuna", "Canned Goods", 6.70, "Jaya Grocer"));
        initProductList.add(new Product("Ayam Brand Tuna", "Canned Goods", 6.85, "AEON"));
        initProductList.add(new Product("Ayam Brand Tuna", "Canned Goods", 6.50, "Econsave"));
        initProductList.add(new Product("Ayam Brand Tuna", "Canned Goods", 6.55, "99 Speedmart"));
        initProductList.add(new Product("Campbell Mushroom Soup", "Canned Goods", 3.70, "Jaya Grocer"));
        initProductList.add(new Product("Campbell Mushroom Soup", "Canned Goods", 3.85, "AEON"));
        initProductList.add(new Product("Campbell Mushroom Soup", "Canned Goods", 3.50, "Econsave"));
        initProductList.add(new Product("Campbell Mushroom Soup", "Canned Goods", 3.55, "99 Speedmart"));
        initProductList.add(new Product("Ayam Brand Sardines", "Canned Goods", 3.90, "Jaya Grocer"));
        initProductList.add(new Product("Ayam Brand Sardines", "Canned Goods", 4.05, "AEON"));
        initProductList.add(new Product("Ayam Brand Sardines", "Canned Goods", 3.70, "Econsave"));
        initProductList.add(new Product("Ayam Brand Sardines", "Canned Goods", 3.75, "99 Speedmart"));
        initProductList.add(new Product("Ayam Brand Mackerel", "Canned Goods", 6.90, "Jaya Grocer"));
        initProductList.add(new Product("Ayam Brand Mackerel", "Canned Goods", 6.05, "AEON"));
        initProductList.add(new Product("Ayam Brand Mackerel", "Canned Goods", 6.70, "Econsave"));
        initProductList.add(new Product("Ayam Brand Mackerel", "Canned Goods", 6.75, "99 Speedmart"));
        initProductList.add(new Product("Hosen Logan", "Canned Goods", 10.90, "Jaya Grocer"));
        initProductList.add(new Product("Hosen Logan", "Canned Goods", 11.05, "AEON"));
        initProductList.add(new Product("Hosen Logan", "Canned Goods", 11.70, "Econsave"));
        initProductList.add(new Product("Hosen Logan", "Canned Goods", 11.75, "99 Speedmart"));
        initProductList.add(new Product("Yeo's Curry Chicken", "Canned Goods", 7.90, "Jaya Grocer"));
        initProductList.add(new Product("Yeo's Curry Chicken", "Canned Goods", 8.05, "AEON"));
        initProductList.add(new Product("Yeo's Curry Chicken", "Canned Goods", 7.70, "Econsave"));
        initProductList.add(new Product("Yeo's Curry Chicken", "Canned Goods", 7.75, "99 Speedmart"));
        initProductList.add(new Product("Alishan Mushroom", "Canned Goods", 3.90, "Jaya Grocer"));
        initProductList.add(new Product("Alishan Mushroom", "Canned Goods", 4.05, "AEON"));
        initProductList.add(new Product("Alishan Mushroom", "Canned Goods", 3.70, "Econsave"));
        initProductList.add(new Product("Alishan Mushroom", "Canned Goods", 3.75, "99 Speedmart"));

        // Dairy Goods
        initProductList.add(new Product("Farmhouse Fresh Milk 1L", "Dairy Goods", 12.50, "Jaya Grocer"));
        initProductList.add(new Product("Farmhouse Fresh Milk 1L", "Dairy Goods", 13.10, "AEON"));
        initProductList.add(new Product("Farmhouse Fresh Milk 1L", "Dairy Goods", 12.40, "99 Speedmart"));
        initProductList.add(new Product("Farmhouse Fresh Milk 1L", "Dairy Goods", 12.25, "Econsave"));
        initProductList.add(new Product("Cheesedale Cheese Plain 6 Pack", "Dairy Goods", 7.15, "Jaya Grocer"));
        initProductList.add(new Product("Cheesedale Cheese Plain 6 Pack", "Dairy Goods", 7.25, "AEON"));
        initProductList.add(new Product("Cheesedale Cheese Plain 6 Pack", "Dairy Goods", 6.95, "99 Speedmart"));
        initProductList.add(new Product("Cheesedale Cheese Plain 6 Pack", "Dairy Goods", 7.05, "Econsave"));
        initProductList.add(new Product("Heinz Vanilla Custard", "Dairy Goods", 8.15, "Jaya Grocer"));
        initProductList.add(new Product("Heinz Vanilla Custard", "Dairy Goods", 8.25, "AEON"));
        initProductList.add(new Product("Heinz Vanilla Custard", "Dairy Goods", 8.95, "99 Speedmart"));
        initProductList.add(new Product("Heinz Vanilla Custard", "Dairy Goods", 8.05, "Econsave"));
        initProductList.add(new Product("Sunglo Low Fat Greek Youghurt", "Dairy Goods", 16.15, "Jaya Grocer"));
        initProductList.add(new Product("Sunglo Low Fat Greek Youghurt", "Dairy Goods", 16.25, "AEON"));
        initProductList.add(new Product("Sunglo Low Fat Greek Youghurt", "Dairy Goods", 16.95, "99 Speedmart"));
        initProductList.add(new Product("Sunglo Low Fat Greek Youghurt", "Dairy Goods", 16.05, "Econsave"));
        initProductList.add(new Product("Philadelphia Cream Cheese", "Dairy Goods", 12.15, "Jaya Grocer"));
        initProductList.add(new Product("Philadelphia Cream Cheese", "Dairy Goods", 12.25, "AEON"));
        initProductList.add(new Product("Philadelphia Cream Cheese", "Dairy Goods", 12.95, "99 Speedmart"));
        initProductList.add(new Product("Philadelphia Cream Cheese", "Dairy Goods", 12.05, "Econsave"));
        initProductList.add(new Product("Emborg Cooking Cream 1L", "Dairy Goods", 22.15, "Jaya Grocer"));
        initProductList.add(new Product("Emborg Cooking Cream 1L", "Dairy Goods", 22.25, "AEON"));
        initProductList.add(new Product("Emborg Cooking Cream 1L", "Dairy Goods", 22.95, "99 Speedmart"));
        initProductList.add(new Product("Emborg Cooking Cream 1L", "Dairy Goods", 23.05, "Econsave"));
        initProductList.add(new Product("Arla Whipping Cream", "Dairy Goods", 9.15, "Jaya Grocer"));
        initProductList.add(new Product("Arla Whipping Cream", "Dairy Goods", 9.25, "AEON"));
        initProductList.add(new Product("Arla Whipping Cream", "Dairy Goods", 9.95, "99 Speedmart"));
        initProductList.add(new Product("Arla Whipping Cream", "Dairy Goods", 9.05, "Econsave"));

        return initProductList;
    }

    public ArrayList initializeDeals() {
        ArrayList<Deal> deals = new ArrayList<>();
        deals.add(new Deal("D01", "Come check out the Econsave November 2022 Promotion Catalogue for the latest deals on groceries!", "https://malaysiafreebies.com/econsave-promotion-catalog/"));
        deals.add(new Deal("D02", "AEON MaxVelu Weekly Savers Promotion Catalogue is out now!", "https://malaysiafreebies.com/aeon-maxvelu-weekly-savers-promotion-catalogue/"));
        deals.add(new Deal("D03", "TF Value Mart Food Ball Savers Sale Promotion Catalogue is available now!", "https://malaysiafreebies.com/tf-value-mart-food-ball-savers-sale-promotion-catalogue-nov-2022/"));
        deals.add(new Deal("D04", "Lotus's Malaysia Offers Exclusive Discount Coupons for GE15 Voters!", "https://malaysiafreebies.com/lotuss-malaysia-app-offers-rm15-discount-coupon-for-ge15/"));
        deals.add(new Deal("D05", "Lotus's Supermarket Promotion Catalogue for November 2022 is out now!", "https://malaysiafreebies.com/lotuss-promotion-catalogue/"));
        deals.add(new Deal("D06", "Lulu Hypermarket Free RM50 Shopping Vouchers Giveaway", "https://malaysiafreebies.com/lulu-hypermarket-free-rm50-shopping-vouchers-giveaways/"));
        return deals;
    }

    public ArrayList initializeRecipes() {
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        recipeList.add(new Recipe("Fried Rice",
                " - 12 oz. (340g) leftover steamed rice\n - 2 eggs, lightly beaten\n - 1 cup of carrot and peas\n - 1 tablespoon soy sauce\n" +
                        " - 3 dashes ground white pepper\n - Salt to taste\n - 2 tablespoon sesame oil",
                "1. Heat up a wok or pan with the sesame oil.\n\n" +
                        "2. Add the carrot and peas, and stir fry until aromatic.\n\n" +
                        "3. Add in the rice and stir well with the ingredients. Add the soy sauce, white pepper and continue to stir the fried rice for a couple of minutes.\n\n" +
                        "4. Using the spatula, push the rice to the side of the wok and make a \"well\" in the middle of the fried rice.\n\n" +
                        "5. Pour the beaten eggs in the \"well.\" Wait for 30 seconds and then cover the eggs with the fried rice. Leave it for 30 seconds to 1 minute.\n\n" +
                        "6.Continue to stir-fry so the eggs form into small pieces and mix well with the fried rice.\n\n" +
                        "7. Add salt to taste and do some quick stirs, dish out and serve hot."));

        recipeList.add(new Recipe("Sesame Chicken",
                " - 1-1/2 pounds boneless skinless chicken breasts, cut into 1-inch pieces\n" +
                        " - 1 to 2 tablespoons sesame oil\n" +
                        " - 1/4 cup honey\n" +
                        " - 1/4 cup soy sauce\n" +
                        " - 1/4 cup water\n" +
                        " - 3 garlic cloves, minced\n" +
                        " - 1/4 teaspoon crushed red pepper flakes\n" +
                        " - 3 teaspoons cornstarch\n" +
                        " - 2 tablespoons cold water\n" +
                        " - 1 tablespoon sesame seeds\n" +
                        " - Hot cooked rice\n\n",
                "1. Select saute or browning setting on a 6-qt. electric pressure cooker. Adjust for medium heat; \n\n" +
                        "2. Add 1 tablespoon of sesame oil. When oil is hot, brown chicken in batches using additional oil " +
                        "as necessary. Press cancel. Return all to pressure cooker. \n\n" +
                        "3. In a bowl, whisk honey, soy sauce, water, garlic and pepper flakes; stir into pressure cooker. Lock lid; close pressure-release valve. Adjust to pressure-cook on high for 4 minutes. \n\n" +
                        "4. Quick-release pressure. In a small bowl, mix cornstarch and water until smooth; stir into pressure cooker. Select saute setting and adjust for low heat. \n\n" +
                        "5. Simmer, stir constantly until thickened, 1-2 minutes. Serve with rice. Sprinkle with sesame seeds."));
        return recipeList;
    }

    public ArrayList initializeItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Basmathi Rice", "Dry Goods", "Pantry", "November 21, 2022", "November 22, 2023", 1));
        items.add(new Item("Sesame Oil", "Dry Goods", "Pantry", "November 21, 2022", "December 14, 2023", 3));
        items.add(new Item("Eggs", "Fresh Goods", "Fridge", "November 21, 2022", "December 1, 2022", 15));
        items.add(new Item("Carrots", "Fresh Goods", "Fridge", "November 21, 2022", "November 28, 2022", 6));
        items.add(new Item("Peas", "Fresh Goods", "Fridge", "November 21, 2022", "November 30, 2022", 20));
        items.add(new Item("Soy Sauce", "Dry Goods", "Cabinet", "November 21, 2022", "Marc 24, 2024", 4));
        items.add(new Item("Chicken Breast", "Fresh Goods", "Fridge", "November 21, 2022", "November 25, 2022", 2));
        items.add(new Item("Honey", "Dry Goods", "Cabinet", "November 21, 2022", "January 12, 2025", 2));
        items.add(new Item("Garlic Cloves", "Fresh Goods", "Pantry", "November 21, 2022", "December 15, 2022", 10));
        items.add(new Item("Pepper Flakes", "Dry Goods", "Cabinet", "November 21, 2022", "April 1, 2023", 1));
        items.add(new Item("Cornstarch", "Dry Goods", "Cabinet", "November 21, 2022", "December 22, 2021", 3));
        items.add(new Item("Sesame Seeds", "Dry Goods", "Pantry", "November 21, 2022", "May 5, 2024", 6));
        items.add(new Item("Salt", "Dry Goods", "Cabinet", "November 21, 2022", "June 6, 2026", 3));
        items.add(new Item("Pepper", "Fresh Goods", "Fridge", "November 21, 2022", "November 29, 2022", 5));
        return items;
    }
}
