package com.example.remember.listener;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.remember.R;
import com.example.remember.Util.MyApplication;
import com.example.remember.activity.BwlActivity;
import com.example.remember.activity.DtActivity;
import com.example.remember.activity.JlActivity;
import com.example.remember.activity.RcActivity;
import com.example.remember.activity.SbActivity;
import com.example.remember.activity.TqActivity;


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
                intent = new Intent(MyApplication.getContext(), RcActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_bwl:{
                intent = new Intent(MyApplication.getContext(), BwlActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_jl:{
                intent = new Intent(MyApplication.getContext(), JlActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_tq:{
                intent = new Intent(MyApplication.getContext(), TqActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_dt:{
                intent = new Intent(MyApplication.getContext(), DtActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_sb:{
                intent = new Intent(MyApplication.getContext(), SbActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_login:{
                Toast.makeText(MyApplication.getContext(),"点击了登陆", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
