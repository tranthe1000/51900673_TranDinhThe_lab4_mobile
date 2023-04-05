package com.example.bai4;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Computer> computers;
    private ComputerAdapter adapter;

    private int min = 10;
    private int max = 100;
    private int random = new Random().nextInt((max - min) + 1) + min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        computers = initData();
        adapter = new ComputerAdapter(computers, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private ArrayList<Computer> initData() {
        ArrayList<Computer> lstComputers = new ArrayList<>();
        Computer computer;
        for (int i = 0; i < random; i++) {
            computer = new Computer(R.drawable.monitor_icon, "PC " + (i + 1));
            lstComputers.add(computer);
        }
        return lstComputers;
    }
}
