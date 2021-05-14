package com.example.app.ui.home;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER = 0;
    public static final int HORIZONTAL_PRODUCT_VIEW = 1;
    public static final int GRID_PRODUCT_VIEW = 2;

    private int type;


    //// Banner Slider
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    /// Banner Slider

    /// Horizontal Product & Grid product

    private String title;
    private List<HorizontalScrollModel> horizontalScrollModelList;

    public HomePageModel(int type, String title, List<HorizontalScrollModel> horizontalScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalScrollModelList = horizontalScrollModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalScrollModel> getHorizontalScrollModelList() {
        return horizontalScrollModelList;
    }

    public void setHorizontalScrollModelList(List<HorizontalScrollModel> horizontalScrollModelList) {
        this.horizontalScrollModelList = horizontalScrollModelList;
    }
    /// Horizontal product & Grid product


}
