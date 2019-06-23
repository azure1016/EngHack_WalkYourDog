package com.quintus.labs.walkdog.Main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.quintus.labs.walkdog.R;
import com.quintus.labs.walkdog.Utils.User;


public class RoleSelectActivity extends AppCompatActivity {

    String password;
    String email;
    boolean preferDoglover = true;
    private Button preferenceContinueButton;
    private Button hobbiesContinueButton;
    private Button dogloverSelectionButton;
    private Button dogownerSelectionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");


        dogloverSelectionButton = findViewById(R.id.dogloverSelectionButton);
        dogownerSelectionButton = findViewById(R.id.dogownerSelectionButton);
        preferenceContinueButton = findViewById(R.id.preferenceContinueButton);
        //By default male has to be selected so below code is added

        dogownerSelectionButton.setAlpha(.5f);
        dogownerSelectionButton.setBackgroundColor(Color.GRAY);


        dogloverSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogloverButtonSelected();
            }
        });

        dogownerSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogownerButtonSelected();
            }
        });

        preferenceContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimeSelectPage();
            }
        });


    }

    public void dogloverButtonSelected() {
        preferDoglover = true;
        dogloverSelectionButton.setBackgroundColor(Color.parseColor("#EDB412"));
        dogloverSelectionButton.setAlpha(1.0f);
        dogownerSelectionButton.setAlpha(.5f);
        dogownerSelectionButton.setBackgroundColor(Color.GRAY);
    }

    public void dogownerButtonSelected() {
        preferDoglover = false;
        dogownerSelectionButton.setBackgroundColor(Color.parseColor("#EDB412"));
        dogownerSelectionButton.setAlpha(1.0f);
        dogloverSelectionButton.setAlpha(.5f);
        dogloverSelectionButton.setBackgroundColor(Color.GRAY);
    }



    public void openTimeSelectPage(){
        if(preferDoglover){
            Intent intent = new Intent(this, TimeSlelectActivity.class);
            intent.putExtra("id","voln"+email);
            intent.putExtra("prefer", "voln");
            startActivity(intent);
        }

        if(!preferDoglover){
            Intent intent = new Intent(this, TimeSlelectActivity.class);
            intent.putExtra("id", "dog"+email);
            intent.putExtra("prefer", "dog");
            startActivity(intent);
        }
    }
}