package com.example.app;

public class Affirmation {
    private int mImageView;
    private String mprod_name;
    private String mprod_code;
    private String mprod_size;
    private String mprod_price;
    private String mprod_availbilty;
    private String mprod_quantity;
    private  int mWish;
    public Affirmation(int imageview, String prod_name, String prod_code, String prod_size, String prod_price, String prod_availabilty,String prod_quantity,int wish){
        mImageView=imageview;
        mprod_name=prod_name;
        mprod_code=prod_code;
        mprod_size=prod_size;
        mprod_price=prod_price;
        mprod_availbilty=prod_availabilty;
        mprod_quantity=prod_quantity;
        mWish=wish;
    }
    public void changeWish(int img){
        mWish=img;
    }
    public void changeQuantity(String text){
        mprod_quantity=text;
    }
    public void changeText1(String text){
        mprod_name=text;
    }
    public int getImageView() {
        return mImageView;
    }

    public String getprod_name() {
        return mprod_name;
    }

    public String getprod_price() {
        return mprod_price;
    }

    public String getprod_code() {
        return mprod_code;
    }

    public String getprod_availbilty() {
        return mprod_availbilty;
    }

    public String getprod_size() {
        return mprod_size;
    }

    public String getprod_quantity(){
        return mprod_quantity;
    }

    public int getmWishimg(){
        return mWish;
    }
}

