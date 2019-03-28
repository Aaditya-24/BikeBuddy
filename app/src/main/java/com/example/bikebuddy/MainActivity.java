package com.example.bikebuddy;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private  SliderAdapter sliderAdapter;

    Button join;
    Button signin;
    Switch adminbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager)findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout)findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

    }

    public void  addDotsIndicator(int position){

        mDots = new TextView[4];
        mDotLayout.removeAllViews(); //stops from creating unlimited pages

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.ColorTransparentWhite));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public  void  joinin(View view)
    {

        join = (Button)findViewById(R.id.Registerjoin);
        Intent int11 = new Intent(MainActivity.this, join_in_page1.class);
        startActivity(int11);
    }

    public void  signin(View view)
    {
        signin = (Button)findViewById(R.id.signin);
        Intent int2 = new Intent(MainActivity.this,sign_in_page.class);
        startActivity(int2);
    }

    public void AdminSide(View view){

        adminbtn = (Switch)findViewById(R.id.admin);
        Intent int3 = new Intent(MainActivity.this,Admin.class);
        startActivity(int3);

    }

}
