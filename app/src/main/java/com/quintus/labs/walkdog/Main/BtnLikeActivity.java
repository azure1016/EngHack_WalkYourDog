package com.quintus.labs.walkdog.Main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.walkdog.R;
import com.quintus.labs.walkdog.Utils.TopNavigationViewHelper;
import com.quintus.labs.walkdog.Models.*;
import com.quintus.labs.walkdog.http.*;


public class BtnLikeActivity extends AppCompatActivity {
    private static final String TAG = "BtnLikeActivity";
    private static final int ACTIVITY_NUM = 1;
    private Context mContext = BtnLikeActivity.this;
    private ImageView like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_like);

        setupTopNavigationView();
        like = findViewById(R.id.like);

        Intent intent = getIntent();

        // TODO: is Line 40-52 necessary?
        String profileUrl = intent.getStringExtra("url");

        switch (profileUrl) {
            case "defaultFemale":
                Glide.with(mContext).load(R.drawable.default_woman).into(like);
                break;
            case "defaultMale":
                Glide.with(mContext).load(R.drawable.default_man).into(like);
                break;
            default:
                Glide.with(mContext).load(profileUrl).into(like);
                break;
        }

        //TODO: create a like record in the database
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                final AlertDialog.Builder normalDialog =
//                        new AlertDialog.Builder(BtnLikeActivity.this);
//                normalDialog.setIcon(R.drawable.logo1);
//                normalDialog.setTitle("MATCH!!!!");
//                normalDialog.setMessage("NOW, you can have a talk?");
//                AlertDialog dialog = normalDialog.show();
//                normalDialog.setPositiveButton("yes",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                            }
//                        });
//
//                normalDialog.setNegativeButton("no",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                            }
//                        });

                Intent mainIntent = new Intent(BtnLikeActivity.this, MainActivity.class);
                startActivity(mainIntent);

            }
        }).start();
    }

    private void setupTopNavigationView() {
        Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
