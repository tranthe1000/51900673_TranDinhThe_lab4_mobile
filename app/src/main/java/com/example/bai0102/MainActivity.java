package com.example.bai0102;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Name> names;
    private NameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        if (savedInstanceState != null) {
            names = savedInstanceState.getParcelableArrayList("data");
        } else {
            names = initData();
        }

        adapter = new NameAdapter(names, this);
        adapter.setOnItemClickListener(new NameAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Name name) {
                Toast.makeText(MainActivity.this, name.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private ArrayList<Name> initData() {
        ArrayList<Name> names = new ArrayList<>();
        Name n;
        for (int i = 1; i <= 20; i++) {
            n = new Name("Item " + i);
            names.add(n);
        }
        return names;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("data", names);
        super.onSaveInstanceState(outState);
    }
}