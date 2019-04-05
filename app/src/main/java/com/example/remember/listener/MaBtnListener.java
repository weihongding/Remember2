package com.example.remember.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.remember.R;
import com.example.remember.Util.CheckUtil;
import com.example.remember.Util.MyApplication;
import com.example.remember.Util.MyDialog;
import com.example.remember.Util.UserSetting;
import com.example.remember.activity.BwlActivity;
import com.example.remember.activity.DtActivity;
import com.example.remember.activity.JlActivity;
import com.example.remember.activity.RcActivity;
import com.example.remember.activity.SbActivity;
import com.example.remember.activity.TqActivity;

import java.util.Map;


public class MaBtnListener implements View.OnClickListener {

    protected Intent intent;
    protected Activity mActivity;
    protected MyDialog mMyDialog;

    public MaBtnListener(Activity activity){
        mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_share:{
                Toast.makeText(MyApplication.getContext(),"点击了分享", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_set:{
                UserSetting.setUserLoginInfo(mActivity,"","");
                CheckUtil.setUserLoginState(mActivity);
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
                View view = mActivity.getLayoutInflater().inflate(R.layout.dialog_layout, null);
                mMyDialog = new MyDialog(mActivity, view, R.style.DialogTheme);
                mMyDialog.setCancelable(true);
                mMyDialog.show();
                EditText edi_account = (EditText)mMyDialog.findViewById(R.id.edit_login_account);
                EditText edi_password = (EditText)mMyDialog.findViewById(R.id.edit_login_password);
                Button btn_login_q = (Button)mMyDialog.findViewById(R.id.btn_login_q);
                Button btn_reg = (Button)mMyDialog.findViewById(R.id.btn_reg);
                Map<String,String> map = UserSetting.getUserLoginInfo(mActivity);
                btn_login_q.setOnClickListener(this);
                btn_reg.setOnClickListener(this);
                edi_account.setText(map.get("account")==null?"":map.get("account"));
                edi_password.setText(map.get("password")==null?"":map.get("password"));
                break;
            }
            case R.id.btn_reg:{
                Toast.makeText(MyApplication.getContext(),"点击了注册", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_login_q:{
                mMyDialog.cancel();
                EditText edi_account = (EditText)mMyDialog.findViewById(R.id.edit_login_account);
                EditText edi_password = (EditText)mMyDialog.findViewById(R.id.edit_login_password);
                CheckBox cb_login_save = (CheckBox)mMyDialog.findViewById(R.id.cb_login_save);
                UserSetting.setUserLoginInfo(mActivity, edi_account.getText().toString(), edi_password.getText().toString());
                Map<String,String> map = UserSetting.getUserLoginInfo(mActivity);
                Toast.makeText(mActivity,map.get("account"), Toast.LENGTH_SHORT).show();
                CheckUtil.setUserLoginState(mActivity);
                if(!cb_login_save.isChecked()) {
                    UserSetting.setUserLoginInfo(mActivity, "", "");
                }
                break;
            }

        }
    }
}
