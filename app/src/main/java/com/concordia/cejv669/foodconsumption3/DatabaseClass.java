package com.concordia.cejv669.foodconsumption3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseClass extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;

    public DatabaseClass(Context context) {
        super(context, Food.TABLE_NAME, null, DATABASE_VERSION);
    }

    public Food addFood(Food f){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Food.COLUMN_FOODNAME, f.getFoodName());
        values.put(Food.COLUMN_CALORIES, f.getCalories());
        values.put(Food.COLUMN_QUANTITY, f.getQuantity());
        values.put(Food.COLUMN_DATE, f.getDate().toString());
        values.put(Food.COLUMN_WARNING,f.isWarning() ?1:0);

        db.insert(Food.TABLE_NAME,null,values);

        return f;

    }

    public List<Food> getAllFood() throws ParseException {
        List <Food> foods =new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery="select * from " + Food.TABLE_NAME;
        Cursor c= db.rawQuery(selectQuery,null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        if( c.moveToFirst())
        {
            do{
                Food food = new Food();
                food.setFoodName(c.getString(c.getColumnIndex(Food.COLUMN_FOODNAME)));
                food.setCalories(c.getDouble(c.getColumnIndex(Food.COLUMN_CALORIES)));
                food.setQuantity(c.getInt(c.getColumnIndex(Food.COLUMN_QUANTITY)));

                food.setDate(sdf.parse(c.getString(c.getColumnIndex(Food.COLUMN_DATE))));
                if(c.getColumnIndex(Food.COLUMN_WARNING)==1)
                {
                    food.setWarning(true);
                }
                else
                {
                    food.setWarning(false);
                }
                foods.add(food);
            }while (c.moveToNext());

        }
        if (c != null)
            c.moveToFirst();
        db.close();
        return foods;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Food.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
