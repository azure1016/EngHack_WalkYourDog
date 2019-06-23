package com.quintus.labs.walkdog.Matched;

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
import com.quintus.labs.walkdog.R;
import com.quintus.labs.walkdog.Utils.TopNavigationViewHelper;
import com.quintus.labs.walkdog.Utils.User;

import java.util.ArrayList;
import java.util.List;


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
//        Users users = new Users("1", "Swati Tripathy", 21, "https://im.idiva.com/author/2018/Jul/shivani_chhabra-_author_s_profile.jpg", "Simple and beautiful Girl", "Acting", 200);
//        usersList.add(users);
//        users = new Users("2", "Ananaya Pandy", 20, "https://i0.wp.com/profilepicturesdp.com/wp-content/uploads/2018/06/beautiful-indian-girl-image-for-profile-picture-8.jpg", "cool Minded Girl", "Dancing", 800);
//        usersList.add(users);
//        users = new Users("3", "Anjali Kasyap", 22, "https://pbs.twimg.com/profile_images/967542394898952192/_M_eHegh_400x400.jpg", "Simple and beautiful Girl", "Singing", 400);
//        usersList.add(users);
//        users = new Users("7", "Sudeshna Roy", 19, "https://talenthouse-res.cloudinary.com/image/upload/c_fill,f_auto,h_640,w_640/v1411380245/user-415406/submissions/hhb27pgtlp9akxjqlr5w.jpg", "Papa's Pari", "Art", 5000);
//        usersList.add(users);
//        adapter.notifyDataSetChanged();
    }

    private void prepareMatchData() {

        //TODO: prepare Match data from the database
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

//        Users users = new Users("1", "Swati Tripathy", 21, "https://im.idiva.com/author/2018/Jul/shivani_chhabra-_author_s_profile.jpg", "Warm heart Girl", "Acting", 200);
//        matchList.add(users);
//        users = new Users("2", "Ananaya Pandy", 20, "https://i0.wp.com/profilepicturesdp.com/wp-content/uploads/2018/06/beautiful-indian-girl-image-for-profile-picture-8.jpg", "dog lover", "Dancing", 800);
//        matchList.add(users);
//        users = new Users("3", "Anjali Kasyap", 22, "https://pbs.twimg.com/profile_images/967542394898952192/_M_eHegh_400x400.jpg", "Simple and beautiful Girl", "Super dog lover", 400);
//        matchList.add(users);
//        users = new Users("4", "Preety Deshmukh", 19, "https://i.ytimg.com/vi/hYvkSHYh_WQ/hqdefault.jpg", "dog lover girl", "swiming", 1308);
//        matchList.add(users);
//        users = new Users("5", "Srutimayee Sen", 20, "https://dp.profilepics.in/profile_pictures/selfie-girls-profile-pics-dp/selfie-pics-dp-for-whatsapp-facebook-profile-25.jpg", "dog lover ", "Drawing", 1200);
//        matchList.add(users);
//        users = new Users("6", "Dikshya Agarawal", 21, "https://pbs.twimg.com/profile_images/485824669732200448/Wy__CJwU.jpeg", "Simple and beautiful Girl", "Sleeping", 700);
//        matchList.add(users);
//        users = new Users("7", "Sudeshna Roy", 19, "https://talenthouse-res.cloudinary.com/image/upload/c_fill,f_auto,h_640,w_640/v1411380245/user-415406/submissions/hhb27pgtlp9akxjqlr5w.jpg", "Papa's Pari", "Art", 5000);
//        matchList.add(users);



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
