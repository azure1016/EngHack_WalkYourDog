package com.quintus.labs.walkdog.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.quintus.labs.walkdog.R;
import com.quintus.labs.walkdog.http.ApiMethods;

public class TimeSlelectActivity extends AppCompatActivity {
    private Button morning;
    private Button afternoon;
    private Button night;
    private String id;
    private String prefer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_select);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        prefer = intent.getStringExtra("prefer");

        morning = findViewById(R.id.morningSelectionButton);
        afternoon = findViewById(R.id.afternoonSelectionButton);
        night = findViewById(R.id.nightSelectionButton);

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               morningChoice();
            }
        });

        afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afternoonChoice();
            }
        });

        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nightChoice();
            }
        });

    }

    public void morningChoice(){
        if(prefer.equals("dog")) {
            Intent intent = new Intent(this, MainActivity.class);
            String time = "2019-06-22-SAT-M";
//        if(prefer.equals("dog")){
//            ApiMethods.createInTimeslot();
//        }
            intent.putExtra("prefer", prefer);

            startActivity(intent);
        }
        if(prefer.equals("voln")){
            Intent intent = new Intent(this, SecondmainActivity.class);
            String time = "2019-06-22-SAT-M";
//        if(prefer.equals("dog")){
//            ApiMethods.createInTimeslot();
//        }
            intent.putExtra("prefer", prefer);

            startActivity(intent);
        }
    }

    public void afternoonChoice(){
        if(prefer.equals("dog")) {
            Intent intent = new Intent(this, MainActivity.class);
            String time = "2019-06-22-SAT-A";
            intent.putExtra("prefer", prefer);
            startActivity(intent);
        }
        if(prefer.equals("voln")){
            Intent intent = new Intent(this, SecondmainActivity.class);
            String time = "2019-06-22-SAT-A";
            intent.putExtra("prefer", prefer);
            startActivity(intent);
        }
    }

    public void nightChoice(){
        if(prefer.equals("dog")) {
            Intent intent = new Intent(this, MainActivity.class);
            String time = "2019-06-22-SAT-N";
            intent.putExtra("prefer", prefer);
            startActivity(intent);
        }
        if(prefer.equals("voln")){
            Intent intent = new Intent(this, SecondmainActivity.class);
            String time = "2019-06-22-SAT-N";
            intent.putExtra("prefer", prefer);
            startActivity(intent);
        }
    }


}
