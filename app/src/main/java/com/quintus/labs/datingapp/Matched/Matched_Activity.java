package com.quintus.labs.datingapp.Matched;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.TopNavigationViewHelper;
import com.quintus.labs.datingapp.Utils.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quintus Labs on 20-Dec-2018.
 * www.quintuslabs.com
 */
public class Matched_Activity extends AppCompatActivity {

    private static final String TAG = "Matched_Activity";
    private static final int ACTIVITY_NUM = 2;
    List<Users> matchList = new ArrayList<>();
    List<User> copyList = new ArrayList<>();
    private Context mContext = Matched_Activity.this;
    private String userId, userSex, lookforSex;
    private double latitude = 37.349642;
    private double longtitude = -121.938987;
    private EditText search;
    private List<Users> usersList = new ArrayList<>();
    private RecyclerView recyclerView, mRecyclerView;
    private ActiveUserAdapter adapter;
    private MatchUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matched);

        setupTopNavigationView();
        searchFunc();


        recyclerView = findViewById(R.id.active_recycler_view);
        mRecyclerView = findViewById(R.id.matche_recycler_view);

        adapter = new ActiveUserAdapter(usersList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareActiveData();

        mAdapter = new MatchUserAdapter(matchList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager1);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareMatchData();


    }

    private void prepareActiveData() {
        Users users = new Users("1", "Sugar", 3, "https://cdn1.medicalnewstoday.com/content/images/articles/322/322868/golden-retriever-puppy.jpg", "a beautiful brown dog", "play game", 200);
        usersList.add(users);
        users = new Users("2", "Catty", 9, "https://www.bluecross.org.uk/sites/default/files/styles/thumbnail_pet/public/pets/177636/544368.jpg?itok=qdIwq-rZ", "a cute Husky", "Dancing", 800);
        usersList.add(users);
        users = new Users("3", "Kawai", 4, "https://tractive.com/static/images/product-images/tratr3g/tractive-gps-3g-dogtracker-dalmatian-dog.jpg", "a cute soptty dog", "Wandering", 400);
        usersList.add(users);
        users = new Users("7", "Donald trump", 2, "https://www.petmd.com/sites/default/files/Acute-Dog-Diarrhea-47066074.jpg", "boring", "Art", 5000);
        usersList.add(users);

        adapter.notifyDataSetChanged();
    }

    private void prepareMatchData() {
        Users users = new Users("1", "Sugar", 3, "https://cdn1.medicalnewstoday.com/content/images/articles/322/322868/golden-retriever-puppy.jpg", "a beautiful brown dog", "play game", 200);
        matchList.add(users);
        users = new Users("2", "Catty", 9, "https://www.bluecross.org.uk/sites/default/files/styles/thumbnail_pet/public/pets/177636/544368.jpg?itok=qdIwq-rZ", "a cute Husky", "Dancing", 800);
        matchList.add(users);
        users = new Users("3", "Kawai", 4, "https://tractive.com/static/images/product-images/tratr3g/tractive-gps-3g-dogtracker-dalmatian-dog.jpg", "a cute soptty dog", "wandering", 400);
        matchList.add(users);
        users = new Users("4", "Bandy", 3, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrbAGg_850YbBE75JT6elMmZPxTL8fT4UGSVoIgNKc7U_ixmnguQ", "cute dog", "swiming", 1308);
        matchList.add(users);
        users = new Users("5", "Clair", 2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSh3kUJU_pXXXqQpiBg_pw37-g0pkok3BJNePj5h0KhtKKVcfoV", "pretty dog ", "play game", 1200);
        matchList.add(users);
        users = new Users("6", "Maven", 1, "https://www.rd.com/wp-content/uploads/2018/04/shutterstock_693756292.jpg", "love sleeping", "Sleeping", 700);
        matchList.add(users);
        users = new Users("7", "Donald trump", 2, "https://www.petmd.com/sites/default/files/Acute-Dog-Diarrhea-47066074.jpg", "boring", "Art", 5000);
        matchList.add(users);

        mAdapter.notifyDataSetChanged();
    }

    private void searchFunc() {
       /* search = findViewById(R.id.searchBar);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchText();
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchText();
            }
        });*/
    }

    /* private void searchText() {
         String text = search.getText().toString().toLowerCase(Locale.getDefault());
         if (text.length() != 0) {
             if (matchList.size() != 0) {
                 matchList.clear();
                 for (User user : copyList) {
                     if (user.getUsername().toLowerCase(Locale.getDefault()).contains(text)) {
                         matchList.add(user);
                     }
                 }
             }
         } else {
             matchList.clear();
             matchList.addAll(copyList);
         }

         mAdapter.notifyDataSetChanged();
     }

     private boolean checkDup(User user) {
         if (matchList.size() != 0) {
             for (User u : matchList) {
                 if (u.getUsername() == user.getUsername()) {
                     return true;
                 }
             }
         }

         return false;
     }

     private void checkClickedItem(int position) {

         User user = matchList.get(position);
         //calculate distance
         Intent intent = new Intent(this, ProfileCheckinMatched.class);
         intent.putExtra("classUser", user);

         startActivity(intent);
     }
 */
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
