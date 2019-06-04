package com.example.lab5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private DishAdapter mDishAdapter;

    private List<Dish> mDishList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        Dish dish = new Dish();
        dish.setName("Coooooooook");
        dish.setTime("55 min");
        mDishList.add(dish);



        mDishAdapter = new DishAdapter(getBaseContext(), mDishList);
        mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecyclerView.setAdapter(mDishAdapter);
        mDishAdapter.notifyDataSetChanged();
    }
}
