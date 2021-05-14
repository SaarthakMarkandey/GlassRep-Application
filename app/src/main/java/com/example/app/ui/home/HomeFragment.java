package com.example.app.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    ///// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    ///// Banner Slider

    ///// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;
    ///// Horizontal Product Layout



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ///// Banner Slider
        bannerSliderViewPager = view.findViewById(R.id.bannerSlider_viewPager);

        sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.banner5,"#8cfffb"));
        sliderModelList.add(new SliderModel(R.drawable.banner6, "#e45319"));
        sliderModelList.add(new SliderModel(R.drawable.banner1, "#c3c3c3"));

        sliderModelList.add(new SliderModel(R.drawable.banner2, "#e7e2e2"));
        sliderModelList.add(new SliderModel(R.drawable.banner3, "#e7e2e2"));
        sliderModelList.add(new SliderModel(R.drawable.banner4,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner5, "#8cfffb"));

        sliderModelList.add(new SliderModel(R.drawable.banner6, "#e45319"));
        sliderModelList.add(new SliderModel(R.drawable.banner1, "#c3c3c3"));
        sliderModelList.add(new SliderModel(R.drawable.banner2, "#e7e2e2"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);
        bannerSliderViewPager.setCurrentItem(currentPage);


        ViewPager.OnPageChangeListener onPageChangeListener= new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state== ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });

        ///// Banner Slider

        ///// Horizontal Product Layout
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalScrollModel> horizontalScrollModelList = new ArrayList<>();
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_1,"Samsung Galaxy M31s", "Rs. 20000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_2,"Samsung Galaxy M31", "Rs. 10000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_3,"Samsung Galaxy M30", "Rs. 12000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_4,"Samsung Galaxy M30s", "Rs. 10000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_5,"Samsung Galaxy A51", "Rs. 25000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_6,"Samsung Galaxy A71", "Rs. 30000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_7,"Samsung Galaxy S10", "Rs. 80000"));
        horizontalScrollModelList.add(new HorizontalScrollModel(R.drawable.featured_image_8,"Samsung Galaxy M42", "Rs. 20000"));


        HorizontalScrollAdapter horizontalScrollAdapter = new HorizontalScrollAdapter(horizontalScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalScrollAdapter);
        horizontalScrollAdapter.notifyDataSetChanged();
        ///// Horizontal Product Layout

        ///// Grid Product Layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_view_all_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalScrollModelList));

        ///// Grid Product Layout

        ////////////

        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,"Products of the Day!",horizontalScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Shirts",horizontalScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Jeans",horizontalScrollModelList));
        homePageModelList.add(new HomePageModel(1,"Products of the Day!",horizontalScrollModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////
        return view;
    }

    //// Banner Slider
    private void pageLooper(){
        if (currentPage== sliderModelList.size()-2){
            currentPage=2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage==1){
            currentPage=sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow(){
        Handler handler= new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }
    //// Banner Slider

}