package com.example.remember.listener;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.remember.R;
import com.example.remember.Util.MyApplication;
import com.example.remember.activity.DtActivity;


public class MaBtnListener implements View.OnClickListener {

    Intent intent;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_share:{
                Toast.makeText(MyApplication.getContext(),"点击了分享", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_set:{
                Toast.makeText(MyApplication.getContext(),"点击了设置", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_rc:{
                Toast.makeText(MyApplication.getContext(),"点击了日程", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_bwl:{
                Toast.makeText(MyApplication.getContext(),"点击了备忘录", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_jl:{
                Toast.makeText(MyApplication.getContext(),"点击了记录", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_tq:{
                Toast.makeText(MyApplication.getContext(),"点击了天气", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_dt:{
                intent = new Intent(MyApplication.getContext(), DtActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_sb:{
                Toast.makeText(MyApplication.getContext(),"点击了设备", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_login:{
                Toast.makeText(MyApplication.getContext(),"点击了登陆", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
