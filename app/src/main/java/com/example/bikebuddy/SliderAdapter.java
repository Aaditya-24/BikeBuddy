package com.example.bikebuddy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bikebuddy.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater LayoutInflater;

    public SliderAdapter(Context context){

        this.context = context;


    }

    //Arrays
    public int[] slide_images = {
            R.drawable.club_sliderview,
            R.drawable.guide_sliderrview,
            R.drawable.trail_sliderview,
            R.drawable.bookride_sliderview
    };

    public String[] slide_headings = {

            "JOIN THE CLUB",
            "GUIDES",
            "UNEXPLORED TRAILS",
            "RENT PREMIUM QUALITY RIDES"
    };

    public String[] slide_desc = {

            "Paid membership to the club to experience platinum features.",
            "Don't let the fear of new trails hold you back. Get connected to native guides to help you on the way.",
            "Take your bike and just visit hidden trails and experience the hidden beauties of nature ",
            "Ride on different beasts everyday. Rent from an amazing collection of superbikes. "

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_imagess);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_head);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_descr);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}
