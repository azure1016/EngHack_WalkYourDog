package com.quintus.labs.datingapp.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.TopNavigationViewHelper;
import com.quintus.labs.datingapp.Models.*;
import com.quintus.labs.datingapp.http.*;

/**
 * Created by Quintus Labs on 19-Dec-2018.
 * www.quintuslabs.com
 */
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
        // TODO: get userId from previous activity: MainActivity
        String USER_ID = "";
        String DOG_ID = "";
        String TIME = "2019-06-22-SAT-M";
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
        //------------ this is an example as how to use the http request mechanism
//        ObserverOnNextListener<RespFormat> respListener = respFormat -> {
//            int result = respFormat.getStatus();
//            if (result != 200) {
//                Toast warning = Toast.makeText(this, "Failed to like!", Toast.LENGTH_SHORT);
//            }
//        };
//        ApiMethods.createLikeDog(new MyObserver<>(this, respListener), DOG_ID, USER_ID, TIME);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
