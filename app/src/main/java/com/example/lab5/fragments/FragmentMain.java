package com.example.lab5.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab5.adapter.DishAdapter;
import com.example.lab5.R;
import com.example.lab5.entity.Recipe;
import com.example.lab5.entity.RecipeDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim Andrienko
 * 6/11/19
 */
public class FragmentMain extends Fragment {


    private RecyclerView mRecyclerView;

    private DishAdapter mDishAdapter;


//    private List<Dish> mDishList = new ArrayList<>();
    private List<RecipeDataProvider>  mRecipeDataProviderList= new ArrayList<>();


    public static FragmentMain newInstance(){
        return new FragmentMain();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_main,container,false);

        List<Recipe> recipeList = new RecipeDataProvider().provider();


        mDishAdapter = new DishAdapter(getContext(), recipeList);
        mRecyclerView = view.findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setAdapter(mDishAdapter);
        mDishAdapter.notifyDataSetChanged();



        return view;
    }
}
