package com.concordia.cejv669.foodconsumption3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    List<Food> foodList;

    FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

   class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodname, calories, quantity,total;
        ImageView warning;

        MyViewHolder(View view) {
            super(view);
            foodname = view.findViewById(R.id.display_foodname);
            calories = view.findViewById(R.id.display_calories);
            quantity = view.findViewById(R.id.display_quantity);
            warning = view.findViewById(R.id.imageView);
            total = view.findViewById(R.id.display_total);
        }
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder viewHolder, int i) {
        final Food food = foodList.get(i);
        viewHolder.foodname.setText(food.getFoodName());
        viewHolder.calories.setText(food.getCalories()+"");
        viewHolder.quantity.setText(food.getQuantity()+"");
        viewHolder.total.setText(food.getCalories()*food.getQuantity()+"");
        viewHolder.warning.setVisibility(food.isWarning()?View.VISIBLE:View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
