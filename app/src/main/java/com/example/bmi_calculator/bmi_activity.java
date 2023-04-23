package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmi_activity extends AppCompatActivity {

android.widget.Button recalculatebmi;
TextView bmidisplay,bmicategory,gender;
Intent intent;
ImageView imageView;

String bmi="";

String height,weight;
double intheight,intweight,intbmi;
RelativeLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

//        getSupportActionBar().setElevation(0);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color =\"white\"></front>"));
//        getSupportActionBar().setTitle("Result ");
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
//        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        recalculatebmi = findViewById(R.id.recalculatebmi);

        intent = getIntent();
        bmidisplay = findViewById(R.id.bmidisplay);
        bmicategory = findViewById(R.id.bmicategory);
        gender = findViewById(R.id.genderdisplay);
        background = findViewById(R.id.contentlayout);
        imageView = findViewById(R.id.imageview);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("Weight");


        intheight = Double.parseDouble(height);
        intweight = Double.parseDouble(weight);

        // Converting height to Meters
        intheight = intheight/100;

        // Calculating BMI
        intbmi = intweight/(intheight*intheight);

        // Converting BMI to String
        bmi = String.valueOf(intbmi);

        if(intbmi < 16 ) {
            bmicategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        } else if (intbmi < 16.9 && intbmi > 16 ) {
            bmicategory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        } else if (intbmi < 18.4 && intbmi > 17 ) {
            bmicategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        } else if (intbmi < 25 && intbmi > 18.4 ) {
            bmicategory.setText("Normal");

            imageView.setImageResource(R.drawable.ok);
        } else if (intbmi < 29.4 && intbmi > 25 ) {
            bmicategory.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        } else  {
            bmicategory.setText("Obese ");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }

        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);

        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(bmi_activity.this,MainActivity.class);
                startActivity(next);
                finish();
            }
        });
    }
}