package com.example.remember.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class UserSetting {

    private static SharedPreferences.Editor editor;
    private static SharedPreferences pref;


    //定位地址
    public static String UserLocation_country="undefineCountry";//国家
    public static String UserLocation_province="undefineProvince";//省
    public static String UserLocation_city="undefineCity";//市
    public static String UserLocation_district="undefineDistrict";//区
    public static String UserLocation_street="undefineStreet";//街道

    public static void setUserLoginInfo(Activity activity,String userName){
         editor = activity.getSharedPreferences("data", Context.MODE_PRIVATE).edit();
         editor.putString("userName",userName);
         editor.apply();
    }

    public static String getUserLoginInfo(Activity activity){
        pref = activity.getSharedPreferences("data",Context.MODE_PRIVATE);
        String name = pref.getString("userName","undefined");
        return name;
    }

}
