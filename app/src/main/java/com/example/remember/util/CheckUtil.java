package com.example.remember.util;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.remember.R;
import com.example.remember.ccs.Client;

import java.util.HashMap;
import java.util.Map;

//检查数据
public class CheckUtil {

    //根据用户名情况设置登陆情况
    public static void setUserLoginState(Activity activity){
        Button btn_login = (Button)activity.findViewById(R.id.btn_login);
        TextView tv_user = (TextView)activity.findViewById(R.id.text_user);
        if(UserSetting.getUserLoginInfo(activity).get("account").equals("")||UserSetting.getUserLoginInfo(activity).get("account")==null){
            btn_login.setVisibility(View.VISIBLE);
            tv_user.setVisibility(View.GONE);
        }else{
            btn_login.setVisibility(View.GONE);
            Map valueMap = UserSetting.getUserLoginInfo(activity);
//            Map<String,String> map = new HashMap<>();
//            map.put("messageType", "login");
//            map.put("value", valueMap.toString());
//            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(map));
//            Log.d(DataUtil.TAG+"Check", json.toString());
//            Client.sendMessage(json);

            tv_user.setText("账号："+valueMap.get("account")+"\n密码："+valueMap.get("password"));
            tv_user.setVisibility(View.VISIBLE);
        }
    }

}
