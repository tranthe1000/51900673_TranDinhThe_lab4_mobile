package com.example.bai3;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Phone> phones;
    private PhoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        phones = initData();
        adapter = new PhoneAdapter(phones, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.removeSelected) {
            for (int k = phones.size() - 1; k >= 0; k--) {
                if (phones.get(k).isChecked()) {
                    phones.remove(k);
                }
            }
            adapter.notifyDataSetChanged();

        } else if (id == R.id.removeAll) {
            phones.clear();
            adapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }

    public static ArrayList<Phone> initData() {
        int[] pics = {R.drawable.ic_apple, R.drawable.ic_samsung, R.drawable.ic_nokia, R.drawable.ic_oppo};
        String[] names = {"Apple", "Samsung", "Nokia", "Oppo"};
        Phone phone;
        ArrayList<Phone> phones = new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            phone = new Phone(pics[i], names[i]);
            phones.add(phone);
        }
        return phones;
    }
}