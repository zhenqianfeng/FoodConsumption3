package com.concordia.cejv669.foodconsumption3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Button b_add = findViewById(R.id.btn_add);

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClass dbc = new DatabaseClass(getApplicationContext());
                final String[] dateStr = new String[1];


                EditText editFoodName = findViewById(R.id.edit_food_name);
                EditText editCalories = findViewById(R.id.edit_calories);
                EditText editQuantity = findViewById(R.id.edit_quantity);
                CalendarView calender = (CalendarView)findViewById(R.id.calendarView);

                boolean warningSign;

                Double num_calories = Double.parseDouble(editCalories.getText().toString());
                Integer num_quantity = Integer.parseInt(editQuantity.getText().toString());

                calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                        dateStr[0] = dayOfMonth + "-" + month+1 + "-" + year;
                    }
                });

                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
                Date add_date = null;
                try {
                    add_date = sdf.parse(dateStr[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (num_calories * num_quantity > 1000) warningSign = true;
                else warningSign = false;


                Food newFood = new Food(editFoodName.getText().toString(),num_calories,num_quantity,add_date,warningSign);

                dbc.addFood(newFood);

                Toast.makeText(getApplicationContext(),"Record added!", Toast.LENGTH_LONG).show();
            }
        });

        Button b_back = findViewById(R.id.btn_back);

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
