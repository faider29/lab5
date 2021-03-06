package com.example.lab5.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5.R;
import com.example.lab5.entity.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxim Andrienko
 * 5/31/19
 */
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishHolder> {

//    private List<Dish> mDishList;
    private Context mContext;
    private List<Recipe> mRecipeDataProviderList;

    public static final String TAG = DishAdapter.class.getSimpleName();

    private String URL = "https://img09.rl0.ru/eda/c487x255i/s1.eda.ru/StaticContent/Photos/160915225201/160926183257/p_O.jpg";

    public DishAdapter(Context context ,List<Recipe> recipeDataProviderList) {
        mContext = context;
        mRecipeDataProviderList = recipeDataProviderList;
    }

    @NonNull
    @Override
    public DishHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        return new DishHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishHolder dishHolder, int i) {
        dishHolder.setNameDish(mRecipeDataProviderList.get(i).getName());
        dishHolder.setTimeDish(mRecipeDataProviderList.get(i).getTime());

        Picasso.get()
//                .load(URL + mDishList.get(i).getImg())
//                .load(mRecipeDataProviderList.get(i).getImages(1))
                .load(mRecipeDataProviderList.get(i).getImages().get(1))
                .error(R.drawable.error)
                .into(dishHolder.getDishImage());
        Log.d(TAG, "Picasso: " + mRecipeDataProviderList.size());

    }

    @Override
    public int getItemCount() {
        return mRecipeDataProviderList == null ? 0:  mRecipeDataProviderList.size();
    }

    public class DishHolder extends RecyclerView.ViewHolder {

        private ImageView mDishImage;
        private TextView mNameDish;
        private TextView mTimeDish;
        private View mView;

        public DishHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mDishImage = itemView.findViewById(R.id.iv_item_main);
            mNameDish = itemView.findViewById(R.id.tv_item_main_dish_name);
            mTimeDish = itemView.findViewById(R.id.tv_item_main_time_cook);
        }

        public ImageView getDishImage() {
            return mDishImage;
        }

        public void setDishImage(Drawable dishImage) {
            mDishImage.setImageDrawable(dishImage);
        }

        public void setNameDish(String nameDish) {
            mNameDish.setText(nameDish);
        }

        public void setTimeDish(String timeDish) {
            mTimeDish.setText(timeDish);
        }
    }
}
