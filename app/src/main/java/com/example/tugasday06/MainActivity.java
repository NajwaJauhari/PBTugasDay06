package com.example.tugasday06;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FashionAdapter fashionAdapter;
    private ArrayList<com.example.tugasday6.FashionModel> fashionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recycleView);
        fashionAdapter = new FashionAdapter(fashionModel, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fashionAdapter);
    }

    private void getData(){
        fashionModel = new ArrayList<>();
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_kf1), getString(R.string.price_kf1),getString(R.string.kf1), R.drawable.kf1));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_kf2), getString(R.string.price_kf2), getString(R.string.kf2),R.drawable.kf2));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_kf3), getString(R.string.price_kf3), getString(R.string.kf3),R.drawable.kf3));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_kf4), getString(R.string.price_kf4), getString(R.string.kf4),R.drawable.kf4));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_kf5), getString(R.string.price_kf5), getString(R.string.kf5),R.drawable.kf5));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_mk1), getString(R.string.price_mk1), getString(R.string.mk1),R.drawable.mk1));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_mk2), getString(R.string.price_mk2), getString(R.string.mk2),R.drawable.mk2));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_mk3), getString(R.string.price_mk3), getString(R.string.mk3),R.drawable.mk3));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_mk4), getString(R.string.price_mk4), getString(R.string.mk4),R.drawable.mk4));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_mk5), getString(R.string.price_mk5), getString(R.string.mk5),R.drawable.mk5));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_p1), getString(R.string.price_p1), getString(R.string.p1),R.drawable.p1));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_p2), getString(R.string.price_p2), getString(R.string.p2),R.drawable.p2));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_p3), getString(R.string.price_p3), getString(R.string.p3),R.drawable.p3));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_p4), getString(R.string.price_p4), getString(R.string.p4),R.drawable.p4));
        fashionModel.add(new com.example.tugasday6.FashionModel(getString(R.string.name_p5), getString(R.string.price_p5), getString(R.string.p5),R.drawable.p5));
    }
}