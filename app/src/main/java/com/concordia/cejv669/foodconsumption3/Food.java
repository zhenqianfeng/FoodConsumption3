package com.concordia.cejv669.foodconsumption3;

import java.util.Date;

public class Food {


    public static final String TABLE_NAME = "Food";

    public static final String COLUMN_FOODNAME = "food_name";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_WARNING = "warning";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_FOODNAME + " TEXT," +
                    COLUMN_CALORIES + " DOUBLE," +
                    COLUMN_QUANTITY + " INTEGER," +
                    COLUMN_DATE + " TEXT," +
                    COLUMN_WARNING + " INTEGER)";

    private String foodName;
    private Double calories;
    private Integer quantity;
    private Date date;
    private boolean warning;

    public Food() {
    }

    public Food(String foodName, Double calories, Integer quantity, Date date, boolean warning) {
        this.foodName = foodName;
        this.calories = calories;
        this.quantity = quantity;
        this.date = date;
        this.warning = warning;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }
}
