package com.example.bikebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Front_page extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        loadfragment(new Home_Fragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
//        getSupportFragmentManager().beginTransaction().replace(new BookRideFragment()).commit();

    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home1:
                    fragment = new Home_Fragment();
                    return true;

//                    INTENTS USED TO GIVE A FULL SCREEN UI TO THE USER
                case R.id.navigation_explore:
//                    getSupportFragmentManager().beginTransaction().replace(new ExplorerFragment()).commit();
                    Intent intent = new Intent(Front_page.this,ExplorerFragment.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_guide:
//                    getSupportFragmentManager().beginTransaction().replace(new GuideFragment()).commit();
                    Intent intent1 = new Intent(Front_page.this,GuideFragment.class);
                    startActivity(intent1);
                    return true;

                case R.id.navigation_trail:
//                    getSupportFragmentManager().beginTransaction().replace(new Trail_map()).commit();
//                    Intent intent2 = new Intent(Front_page.this,Trail_map.class);
//                    startActivity(intent2);
//                    return true;
                    fragment = new Trail_map();


                case R.id.navigation_book:
//                    getSupportFragmentManager().beginTransaction().replace(new BookRideFragment()).commit();
                    Intent intent3 = new Intent(Front_page.this,BookRideFragment.class);
                    startActivity(intent3);
                    return true;
            }
            return loadfragment(fragment);
        }

        private boolean loadfragment(Fragment fragment){
         if(fragment!=null){
             getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.fragment_container,fragment)
                     .commit();
             return true;
         }
         return false;
        }



    @Override
    public void onBackPressed() {
            finishAffinity();
        super.onBackPressed();
    }
}






