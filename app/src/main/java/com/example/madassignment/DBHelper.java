package com.example.madassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.madassignment.adapters.ProductAdapter;
import com.example.madassignment.models.Deal;
import com.example.madassignment.models.Item;
import com.example.madassignment.models.Product;
import com.example.madassignment.models.Recipe;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodX Database";
    private static final String PRODUCT_TABLE = "products";
    private static final String DEAL_TABLE = "deals";
    private static final String USER_TABLE = "users";
    private static final String ITEM_TABLE = "items";
    private static final String RECIPE_TABLE = "recipes";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProductTable = "create table " + PRODUCT_TABLE + "(productID TEXT PRIMARY KEY, productName TEXT, productType TEXT, price REAL, grocer TEXT)";
        String createDealTable = "create table " + DEAL_TABLE + "(dealID TEXT PRIMARY KEY, dealText TEXT, dealLink TEXT)";
        String createUserTable = "create table " + USER_TABLE + "(username TEXT PRIMARY KEY, password TEXT)";
        String createItemTable = "create table " + ITEM_TABLE + "(name TEXT PRIMARY KEY, category TEXT, storage TEXT, sDate TEXT, eDate TEXT, qty TEXT)";
        String createRecipeTable = "create table " + RECIPE_TABLE + "(dishName TEXT PRIMARY KEY, ingredients TEXT, instructions TEXT)";
        db.execSQL(createProductTable);
        db.execSQL(createDealTable);
        db.execSQL(createUserTable);
        db.execSQL(createItemTable);
        db.execSQL(createRecipeTable);
        ProductAdapter pa = new ProductAdapter();
        ArrayList<Deal> dealList = pa.initializeDeals();
        for (Deal d : dealList) {
            ContentValues cv = new ContentValues();
            cv.put("dealID", d.getDealID());
            cv.put("dealText", d.getDealText());
            cv.put("dealLink", d.getDealLink());
            db.insert(DEAL_TABLE, null, cv);
        }
        ArrayList<Product> prodList = pa.initializeProducts();
        for (Product p : prodList) {
            ContentValues cv = new ContentValues();
            cv.put("productName", p.getProductName());
            cv.put("productType", p.getProductType());
            cv.put("price", p.getPrice());
            cv.put("grocer", p.getGrocer());
            db.insert(PRODUCT_TABLE, null, cv);
        }
        ArrayList<Recipe> recipes = pa.initializeRecipes();
        for (Recipe r : recipes) {
            ContentValues cv = new ContentValues();
            cv.put("dishName", r.getDishesname());
            cv.put("ingredients", r.getIngredients());
            cv.put("instructions", r.getInstructions());
            db.insert(RECIPE_TABLE, null, cv);
        }
        ArrayList<Item> items = pa.initializeItems();
        for (Item i : items) {
            ContentValues cv = new ContentValues();
            cv.put("name", i.getName());
            cv.put("category", i.getCategory());
            cv.put("storage", i.getStorage());
            cv.put("sDate", i.getsDate());
            cv.put("eDate", i.geteDate());
            cv.put("qty", i.getQty());
            db.insert(ITEM_TABLE, null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE if exists " + PRODUCT_TABLE);
        db.execSQL("DROP TABLE if exists " + DEAL_TABLE);
        db.execSQL("DROP TABLE if exists " + USER_TABLE);
        db.execSQL("DROP TABLE if exists " + ITEM_TABLE);
        onCreate(db);
    }

    public ArrayList getRecipes() {
        SQLiteDatabase myDB = this.getReadableDatabase();
        ArrayList<Recipe> recipesList = new ArrayList<>();
        String query = "select * from recipes";
        Cursor cursor = myDB.rawQuery(query, null);
        cursor.moveToFirst();
        if (cursor!=null) {
            while (!cursor.isAfterLast()) {
                String dishname = cursor.getString(cursor.getColumnIndexOrThrow("dishName"));
                String ingredients = cursor.getString(cursor.getColumnIndexOrThrow("ingredients"));
                String instructions = cursor.getString(cursor.getColumnIndexOrThrow("instructions"));
                Recipe recipe = new Recipe(dishname, ingredients, instructions);
                recipesList.add(recipe);
                cursor.moveToNext();
            }
        }
        return recipesList;
    }

    public boolean addItem(String name, String category, String storage, String sDate, String eDate, String qty) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("storage", storage);
        contentValues.put("sDate", sDate);
        contentValues.put("eDate", eDate);
        contentValues.put("qty", qty);

        if (sqLiteDatabase.insert("items", null, contentValues) == -1)
            return false;
        else
            return true;
    }

    public ArrayList getItemNames() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> itemNames = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + ITEM_TABLE, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            itemNames.add(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            cursor.moveToNext();
        }
        return itemNames;
    }

    public Item getItemDetails(String itemname) {
        SQLiteDatabase db = this.getReadableDatabase();
        String name = "";
        String category = "";
        String storage = "";
        String sDate = "";
        String eDate = "";
        int qty = 0;
        Item i = new Item(name, category, storage, sDate, eDate, qty);

        Cursor cursor = db.rawQuery("select * from " + ITEM_TABLE + " where name = ?", new String[]{itemname});
        cursor.moveToFirst();
        String itemName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String itemCategory = cursor.getString(cursor.getColumnIndexOrThrow("category"));
        String itemStorage = cursor.getString(cursor.getColumnIndexOrThrow("storage"));
        String itemSDate = cursor.getString(cursor.getColumnIndexOrThrow("sDate"));
        String itemEDate = cursor.getString(cursor.getColumnIndexOrThrow("eDate"));
        int itemQty = cursor.getInt(cursor.getColumnIndexOrThrow("qty"));

        i.setName(itemName);
        i.setCategory(itemCategory);
        i.setStorage(itemStorage);
        i.setsDate(itemSDate);
        i.seteDate(itemEDate);
        i.setQty(itemQty);
        return i;
    }

    public void deleteItem(String itemname) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ITEM_TABLE, "name=?", new String[]{itemname});
    }

    public Boolean insertUser (String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean validateUsername (String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public Boolean validateUser (String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public ArrayList getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> productList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + PRODUCT_TABLE, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("productName"));
            String type = cursor.getString(cursor.getColumnIndexOrThrow("productType"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            String grocer = cursor.getString(cursor.getColumnIndexOrThrow("grocer"));

            Product p = new Product(name, type, price, grocer);
            productList.add(p);
            cursor.moveToNext();
        }
        return productList;
    }

    public ArrayList getUniqueProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> uniqueProductList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + PRODUCT_TABLE + " group by productName", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("productName"));
            String type = cursor.getString(cursor.getColumnIndexOrThrow("productType"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            String grocer = cursor.getString(cursor.getColumnIndexOrThrow("grocer"));

            Product p = new Product(name, type, price, grocer);
            uniqueProductList.add(p);
            cursor.moveToNext();
        }
        return uniqueProductList;
    }

    public ArrayList getGrocerList(String name, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> grocers = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + PRODUCT_TABLE + " where productName=? AND productType=? group by grocer order by price ASC", new String[]{name, type});
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String prodName = cursor.getString(cursor.getColumnIndexOrThrow("productName"));
            String prodType = cursor.getString(cursor.getColumnIndexOrThrow("productType"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            String grocer = cursor.getString(cursor.getColumnIndexOrThrow("grocer"));

            Product p = new Product(prodName, prodType, price, grocer);
            grocers.add(p);
            cursor.moveToNext();
        }
        return grocers;
    }

    public double getHighestPrice (String name, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select MAX(price) from " + PRODUCT_TABLE + " where productName=? AND productType=?", new String[]{name, type});
        cursor.moveToFirst();
        double highestPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("MAX(price)"));
        return highestPrice;
    }

    public double getLowestPrice (String name, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select MIN(price) from " + PRODUCT_TABLE + " where productName=? AND productType=?", new String[]{name, type});
        cursor.moveToFirst();
        double lowestPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("MIN(price)"));
        return lowestPrice;
    }

    public double getAveragePrice(String name, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select AVG(price) from " + PRODUCT_TABLE + " where productName=? AND productType=?", new String[]{name, type});
        cursor.moveToFirst();
        double lowestPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("AVG(price)"));
        return lowestPrice;
    }

    public ArrayList getProductsInCat(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> productsInCat = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + PRODUCT_TABLE + " where productType=? group by productName", new String[]{type});
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String prodName = cursor.getString(cursor.getColumnIndexOrThrow("productName"));
            String prodType = cursor.getString(cursor.getColumnIndexOrThrow("productType"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            String grocer = cursor.getString(cursor.getColumnIndexOrThrow("grocer"));

            Product p = new Product(prodName, prodType, price, grocer);
            productsInCat.add(p);
            cursor.moveToNext();
        }
        return productsInCat;
    }

    public boolean addProducts(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("productName", product.getProductName());
        cv.put("productType", product.getProductType());
        cv.put("price", product.getPrice());
        cv.put("grocer", product.getGrocer());

        db.insert(PRODUCT_TABLE, null, cv);
        return true;
    }

    public boolean updateProduct(String prodName, String prodGrocer, String prodType, double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("productName", prodName);
        cv.put("productType", prodType);
        cv.put("price", price);
        cv.put("grocer", prodGrocer);
        db.update(PRODUCT_TABLE, cv, "productName=? AND grocer=? AND productType=?", new String[]{prodName, prodGrocer, prodType});
        return true;
    }

    public boolean deleteProduct(String prodName, String prodGrocer, String prodType) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PRODUCT_TABLE, "productName=? AND grocer=? AND productType=?", new String[]{prodName, prodGrocer, prodType});
//        db.execSQL("delete from " + PRODUCT_TABLE);
        return true;
    }

    public boolean addDeals(String dealID, String dealText, String dealLink) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Deal> deals = this.getDeals();
        for (Deal d : deals) {
            if (d.getDealID() == dealID) {
                return false;
            }
        }
        ContentValues cv = new ContentValues();
        cv.put("dealID", dealID);
        cv.put("dealText", dealText);
        cv.put("dealLink", dealLink);
        db.insert(DEAL_TABLE, null, cv);
        return true;
    }

    public ArrayList getDeals() {
        ArrayList<Deal> deals = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DEAL_TABLE, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow("dealID"));
            String text = cursor.getString(cursor.getColumnIndexOrThrow("dealText"));
            String link = cursor.getString(cursor.getColumnIndexOrThrow("dealLink"));
            Deal d = new Deal(id, text, link);
            deals.add(d);
            cursor.moveToNext();
        }
        return deals;
    }

    public boolean deleteDeal(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DEAL_TABLE, "dealID=?", new String[]{ID});
        return true;
    }

}
