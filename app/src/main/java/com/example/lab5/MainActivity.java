package com.example.lab5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private DishAdapter mDishAdapter;


    private List<Dish> mDishList = new ArrayList<>();
    private List<RecipeDataProvider>  mRecipeDataProviderList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        List<Recipe> recipeList = new RecipeDataProvider().provider();

//        Dish dish = new Dish();
//        dish.setName("Coooooooook");
//        dish.setTime("55 min");
//        mDishList.add(dish);

//        Recipe recipe = new Recipe();


        mDishAdapter = new DishAdapter(getBaseContext(), recipeList);
        mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),2));
        mRecyclerView.setAdapter(mDishAdapter);
        mDishAdapter.notifyDataSetChanged();
    }
}
