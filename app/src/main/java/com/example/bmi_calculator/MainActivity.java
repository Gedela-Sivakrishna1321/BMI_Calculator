package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

android.widget.Button calculatebmi;
TextView currentweight,currentage,currentheight;
ImageView incrementage,incrementweight,decrementage,decrementweight;
SeekBar seekbarforheight;
RelativeLayout male,female;

int intweight=55;
int intage=22;
int currentprogress;
String intprogress="170";
String typeofuser="0";
String weight2 = "55";
String age2="22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




        calculatebmi = findViewById(R.id.calculatebmi);
        currentheight = findViewById(R.id.currentheight);
        currentage = findViewById(R.id.currentage);
        currentweight = findViewById(R.id.currentweight);
        incrementage = findViewById(R.id.incrementage);
        incrementweight = findViewById(R.id.incrementweight);
        decrementage = findViewById(R.id.decrementage);
        decrementweight = findViewById(R.id.decrementweight);
        seekbarforheight = findViewById(R.id.seekbar);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        // Male onclick listner
        male.setOnClickListener(v -> {
            male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
            female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
            typeofuser = "Male";
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });

        seekbarforheight.setMax(300);
        seekbarforheight.setProgress(170);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                intprogress = String.valueOf(currentprogress);
                currentheight.setText(intprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Increment Age
        incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++intage;
                age2 = String.valueOf(intage);
                currentage.setText(age2);
            }
        });

        // Decrement Age
        decrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --intage;
                age2 = String.valueOf(intage);
                currentage.setText(age2);
            }
        });

        // Increment Weight
        incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++intweight;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });

        // Decrement Weight
        decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --intweight;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });


        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select your gender", Toast.LENGTH_SHORT).show();
                } else if (intprogress.equals("0")) {
                    Toast.makeText(getApplicationContext(),"Select your Height",Toast.LENGTH_SHORT).show();
                } else if (intage == 0 || intage < 0) {
                    Toast.makeText(getApplicationContext(),"Incorrect age",Toast.LENGTH_SHORT).show();
                } else if (intweight == 0 || intweight < 0) {
                    Toast.makeText(getApplicationContext(),"Incorrect weight",Toast.LENGTH_SHORT).show();
                } else {

                    Intent next = new Intent(MainActivity.this,bmi_activity.class);
                    next.putExtra("gender",typeofuser);
                    next.putExtra("height",intprogress);
                    next.putExtra("age",age2);
                    next.putExtra("Weight",weight2);
                    startActivity(next);


                }


            }
        });

    }
}