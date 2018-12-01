package com.example.raifur.foodgradingsystem.ForIntro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raifur.foodgradingsystem.MainActivity;
import com.example.raifur.foodgradingsystem.R;
import com.example.raifur.foodgradingsystem.SharedPreference.PreferencManager;

public class Welcome extends AppCompatActivity {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int[]layouts;
    private LinearLayout dotsLayout;
    private TextView[]dots;
    private Button btnSkip,btnNext;
    private PreferencManager preferencManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //checking for the first time launch-before calling setContentView

        preferencManager = new PreferencManager(this);
        if (!preferencManager.isFirstTimeLaunch()){

            launchHomeScreen();
            finish();

        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.welcome);

        viewPager = findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout)findViewById(R.id.layoutDots);
        btnSkip = (Button)findViewById(R.id.btn_skip);
        btnNext = (Button)findViewById(R.id.btn_next);

        //layouts of all welcome sliders
        //add few more layouts if needed
        layouts = new int[]{
                R.layout.welcome1,
                R.layout.welcom2,
                R.layout.welcome3,
                R.layout.welcome4
        };
        //adding bottom dots
        addBottomDots(0);

        //making notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerChangeListener);


        //button implement for skip
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking for last page
                //if last home page will be launched
                int current = getItem(+1);

                if (current<layouts.length){
                    //move to next screen
                    viewPager.setCurrentItem(current);

                }else {
                    launchHomeScreen();
                }
            }
        });
    }

    private void addBottomDots(int currentPage){
        dots = new TextView[layouts.length];

        int[]colorActive = getResources().getIntArray(R.array.array_dot_active);
        int []colorInActive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInActive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[currentPage].setTextColor(colorActive[currentPage]);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+i;
    }

    private void launchHomeScreen(){
        preferencManager.setFirstTimeLaunch(false);
        startActivity(new Intent(Welcome.this,MainActivity.class));
        finish();
    }

    //view pager change listener
    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int position) {

            addBottomDots(position);

            //change the next button text 'NEXT'/'GOT IT'
            if (position == layouts.length - 1){
                //last page make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            }else {
                //Still page are Left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    //making notification bar transparent
    private void changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    //View pager Adapter
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject( View view,  Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View)object;
            container.removeView(view);
        }
    }
}
