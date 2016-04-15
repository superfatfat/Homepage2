package com.fatfat.homepage2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuser on 2016/4/13.
 */
public class FoodFragment extends Fragment {
    private List<Food> foodList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            foodList = getFoodList();

    }

    private List<Food> getFoodList(){
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food(R.drawable.food1,"food1"));
        foodList.add(new Food(R.drawable.food2,"food2"));
        foodList.add(new Food(R.drawable.food3,"food3"));
        foodList.add(new Food(R.drawable.food4,"food4"));
        foodList.add(new Food(R.drawable.food5,"food5"));
        foodList.add(new Food(R.drawable.food6,"food6"));
        foodList.add(new Food(R.drawable.food7,"food7"));
        return foodList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.rec,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rvFood);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(),1));
        recyclerView.setAdapter(new FoodAdater(inflater.getContext(),foodList));
        return view;
    }

    private class FoodAdater extends RecyclerView.Adapter<FoodAdater.MyViewHolder> {
        private Context context;
        private List<Food> foodList;
        private LayoutInflater layoutInflater;
        public FoodAdater(Context context, List<Food> foodList) {
            this.context = context;
            this.foodList = foodList;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = layoutInflater.inflate(R.layout.food,parent,false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final Food food = foodList.get(position);
            holder.ivImage.setImageResource(food.getImageId());
            holder.tvName.setText(food.getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,FoodActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("food",food);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }



        @Override
        public int getItemCount() {
            return foodList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImage;
            TextView tvName,tvPrice;
            public MyViewHolder(View itemView) {
                super(itemView);
                ivImage = (ImageView)itemView.findViewById(R.id.ivFood);
                tvName = (TextView)itemView.findViewById(R.id.tvFoodTitle);
                tvPrice = (TextView)itemView.findViewById(R.id.tvFoodTitle);
            }
        }

    }
}
