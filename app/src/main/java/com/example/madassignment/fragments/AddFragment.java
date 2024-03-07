package com.example.madassignment.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;
import com.example.madassignment.adapters.ItemAdapter;
import com.example.madassignment.fragments.InventoryFragment;

import java.util.ArrayList;
import java.util.Calendar;


public class AddFragment extends Fragment implements ItemAdapter.ItemClickListener{

    EditText etName, etCategory, etStorage, etQuantity;
    TextView tvSDate, tvEDate;
    //    ListView listView;
    RecyclerView itemView;
    DBHelper databaseHelper;
    Button btAddItem;
    ArrayList arrayList;
    //    ArrayAdapter arrayAdapter;
    ItemAdapter itemAdapter;
    DatePickerDialog datePickerDialog;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);
        View lv = inflater.inflate(R.layout.fragment_inventory, container, false);
        etName = (EditText) rootView.findViewById(R.id.itemName);
        etCategory = (EditText) rootView.findViewById(R.id.itemCategory);
        etStorage = (EditText) rootView.findViewById(R.id.itemStorage);
        tvSDate = (TextView) rootView.findViewById(R.id.storageDate);
        tvEDate = (TextView) rootView.findViewById(R.id.expiryDate);
        etQuantity = (EditText) rootView.findViewById(R.id.quantity);
        btAddItem = (Button) rootView.findViewById(R.id.bt_addItem);
        itemView = lv.findViewById(R.id.item_list);



        tvSDate.setText(getTodaysDate());

        databaseHelper = new DBHelper(rootView.getContext());

        arrayList = databaseHelper.getItemNames();

        itemAdapter = new ItemAdapter(arrayList, lv.getContext(), this::selectedItem);

        itemView.setAdapter(itemAdapter);

        tvSDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initDatePicker(rootView, tvSDate);
                popDatePicker(rootView);
            }
        });

        tvEDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initDatePicker(rootView, tvEDate);
                popDatePicker(rootView);
            }
        });
        //fried rice : rice, sesame oil, egg, carrot, peas, soy sauce, chicken breast, honey, water, garlic cloves, pepper flakes, cornstarch, sesame seeds, salt, pepper

        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, category, storage, sDate, eDate, qty;
                name = etName.getText().toString();
                category = etCategory.getText().toString();
                storage = etStorage.getText().toString();
                sDate = tvSDate.getText().toString();
                eDate = tvEDate.getText().toString();
                qty = etQuantity.getText().toString();

                if (!name.isEmpty() || !category.isEmpty() || !storage.isEmpty() || !qty.isEmpty()) {
                    if(databaseHelper.addItem(name, category, storage, sDate, eDate, qty)) {
                        Toast.makeText(rootView.getContext(), "Item Inserted", Toast.LENGTH_SHORT).show();

                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getItemNames());
                        itemAdapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(rootView.getContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                }

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                InventoryFragment inventoryFragment = new InventoryFragment();
                fragmentTransaction.replace(R.id.flFragment, inventoryFragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month += 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker(View rootView, TextView tv) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                tv.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(rootView.getContext(), style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + ", " + year;
    }

    private String getMonthFormat(int month) {

        if (month == 1)
            return "January";
        if (month == 2)
            return "February";
        if (month == 3)
            return "March";
        if (month == 4)
            return "April";
        if (month == 5)
            return "May";
        if (month == 6)
            return "June";
        if (month == 7)
            return "July";
        if (month == 8)
            return "August";
        if (month == 9)
            return "September";
        if (month == 10)
            return "October";
        if (month == 11)
            return "November";
        if (month == 12)
            return "December";

        return "JAN";
    }

    public void popDatePicker(View view) {
        datePickerDialog.show();
    }

    @Override
    public void selectedItem(String itemName, View rootView) {
//        SelectedProductFragment selectedProductFragment = new SelectedProductFragment();
//        Bundle data = new Bundle();
//        data.putSerializable("Product", product);
//        selectedProductFragment.setArguments(data);
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.flFragment, selectedProductFragment, "findSelectedProductFragment")
//                .addToBackStack(null)
//                .commit();
    }


}
