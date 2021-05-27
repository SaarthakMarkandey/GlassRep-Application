package com.example.app;


public class PowerModel {
    private int p_imageView;
    private String p_prod_name,p_prod_code,p_prod_specs,p_sph_right,p_sph_left,p_cyl_right,p_cyl_left,p_axis_right,p_axis_left,p_additional_right,p_additional_left,p_username;

    public PowerModel(int imageView,String prod_name,String prod_code,String prod_specs,String sph_right,String sph_left,String cyl_right,String cyl_left,String axis_right,String axis_left,String additional_right,String additional_left,String username){
        p_imageView=imageView;
        p_prod_name=prod_name;
        p_prod_code=prod_code;
        p_prod_specs=prod_specs;
        p_sph_right=sph_right;
        p_sph_left=sph_left;
        p_cyl_left=cyl_left;
        p_cyl_right=cyl_right;
        p_axis_right=axis_right;
        p_axis_left=axis_left;
        p_additional_left=additional_left;
        p_additional_right=additional_right;
        p_username=username;
    }

    public void change_sph_right(String sr){
        p_sph_right=sr;
    }

    public void change_sph_left(String sr){
        p_sph_left=sr;
    }

    public void change_cyl_right(String sr){
        p_cyl_right=sr;
    }

    public void change_cyl_left(String sr){
        p_cyl_left=sr;
    }

    public void change_axis_right(String sr){
        p_axis_right=sr;
    }

    public void change_axis_left(String sr){
        p_axis_left=sr;
    }

    public void change_add_left(String sr){
        p_additional_left=sr;
    }

    public void change_add_right(String sr){
        p_additional_right=sr;
    }
    public void change_username(String sr){
        p_username=sr;
    }

    public int getImage(){
        return p_imageView;
    }
    public String getprod_name(){
        return p_prod_name;
    }
    public String getprod_code(){
        return p_prod_code;
    }
    public String getprod_specs(){
        return p_prod_specs;
    }

    public String get_sph_right(){
        return p_sph_right;
    }

    public String get_sph_left(){
        return p_sph_left;
    }

    public String get_cyl_right(){
        return p_cyl_right;
    }

    public String get_cyl_left(){
        return p_cyl_left;
    }

    public String get_axis_right(){
        return p_axis_right;
    }

    public String get_axis_left(){
        return p_axis_left;
    }

    public String get_additional_right(){
        return p_additional_right;
    }

    public String get_additional_left(){
        return p_additional_left;
    }public String get_username(){
        return p_username;
    }



}
