package com.example.remember.Util;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remember.R;

//检查数据
public class CheckUtil {

    //根据用户名情况设置登陆情况
    public static void setUserLoginState(Activity activity){
        Button btn_login = (Button)activity.findViewById(R.id.btn_login);
        TextView tv_user = (TextView)activity.findViewById(R.id.text_user);
        if(UserSetting.getUserLoginInfo(activity).equals("undefined")){
            btn_login.setVisibility(View.VISIBLE);
            tv_user.setVisibility(View.GONE);
        }else{
            btn_login.setVisibility(View.GONE);
            tv_user.setText("用户："+UserSetting.getUserLoginInfo(activity));
            tv_user.setVisibility(View.VISIBLE);
        }
    }

}
