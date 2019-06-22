package com.quintus.labs.datingapp.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.quintus.labs.datingapp.R;

public class TimeSlelectActivity extends AppCompatActivity {
    private Button morning;
    private Button afternoon;
    private Button night;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_select);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

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
        Intent intent = new Intent(this, MainActivity.class);
        String time = "morning";
        startActivity(intent);
    }

    public void afternoonChoice(){
        Intent intent = new Intent(this, MainActivity.class);
        String time = "afternoon";
        startActivity(intent);
    }

    public void nightChoice(){
        Intent intent = new Intent(this, MainActivity.class);
        String time = "night";
        startActivity(intent);
    }

}
