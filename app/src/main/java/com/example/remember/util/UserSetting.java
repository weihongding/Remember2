package com.example.remember.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.remember.entity.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class UserSetting {

    public static UserInfo user = new UserInfo();
    private static SharedPreferences.Editor editor;
    private static SharedPreferences pref;


    //定位地址
    public static String UserLocation_country="undefineCountry";//国家
    public static String UserLocation_province="undefineProvince";//省
    public static String UserLocation_city="undefineCity";//市
    public static String UserLocation_district="undefineDistrict";//区
    public static String UserLocation_street="undefineStreet";//街道

    //存入自动登陆信息
    public static void setUserLoginInfo(Activity activity,String account,String password){
         editor = activity.getSharedPreferences("UserInfo", Context.MODE_PRIVATE).edit();
         editor.putString("account",account);
         editor.putString("password",password);
         editor.apply();
    }

    //获取自动登录信息
    public static Map<String,String> getUserLoginInfo(Activity activity){
        pref = activity.getSharedPreferences("UserInfo",Context.MODE_PRIVATE);
        Map<String,String> map = new HashMap<>();
        String account = pref.getString("account","");
        String password = pref.getString("password","");
        map.put("account",account);
        map.put("password",password);
        return map;
    }

}
