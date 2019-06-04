package com.example.lab5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxim Andrienko
 * 5/31/19
 */
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishHolder> {

    private List<Dish> mDishList;
    private Context mContext;

    public static final String TAG = DishAdapter.class.getSimpleName();

    private String URL = "https://img09.rl0.ru/eda/c487x255i/s1.eda.ru/StaticContent/Photos/160915225201/160926183257/p_O.jpg";

    public DishAdapter(Context context, List<Dish> dishList) {
        mContext = context;
        mDishList = dishList;
    }

    @NonNull
    @Override
    public DishHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        return new DishHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishHolder dishHolder, int i) {
        dishHolder.setNameDish(mDishList.get(i).getName());
        dishHolder.setTimeDish(mDishList.get(i).getTime());

        Picasso.get()
//                .load(URL + mDishList.get(i).getImg())
                .load(Uri.parse(URL))
                .error(R.drawable.error)
                .into(dishHolder.getDishImage());
        Log.d(TAG, "Picasso: " + mDishList.size());

    }

    @Override
    public int getItemCount() {
        return mDishList == null ? 0:  mDishList.size();
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
