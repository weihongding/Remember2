package com.example.remember.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.remember.R;
import com.example.remember.util.CheckUtil;
import com.example.remember.util.DataUtil;
import com.example.remember.util.MyApplication;
import com.example.remember.util.MyDialog;
import com.example.remember.util.UserSetting;
import com.example.remember.activity.BwlActivity;
import com.example.remember.activity.DtActivity;
import com.example.remember.activity.JlActivity;
import com.example.remember.activity.RcActivity;
import com.example.remember.activity.SbActivity;
import com.example.remember.activity.TqActivity;

import java.util.Map;


public class MaBtnListener implements View.OnClickListener {

    private Activity mActivity;

    public MaBtnListener(Activity activity){
        mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mail:{
                Toast.makeText(MyApplication.getContext(),"点击了分享", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_set:{
                UserSetting.setUserLoginInfo(mActivity,"","");
                CheckUtil.setUserLoginState(mActivity);
                break;
            }
            case R.id.btn_rc:{
                Intent intent = new Intent(MyApplication.getContext(), RcActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_bwl:{
                Intent intent = new Intent(MyApplication.getContext(), BwlActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_jl:{
                Intent intent = new Intent(MyApplication.getContext(), JlActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_tq:{
                Intent intent = new Intent(MyApplication.getContext(), TqActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_dt:{
                Intent intent = new Intent(MyApplication.getContext(), DtActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_sb:{
                Intent intent = new Intent(MyApplication.getContext(), SbActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//添加一个flag
                MyApplication.getContext().startActivity(intent);
                break;
            }
            case R.id.btn_login:{
                MyDialog.loginDialog.show();
                Button btn_login_q = (Button)MyDialog.loginDialog.findViewById(R.id.btn_login_q);
                Button btn_reg = (Button)MyDialog.loginDialog.findViewById(R.id.btn_reg);
                btn_login_q.setOnClickListener(this);
                btn_reg.setOnClickListener(this);
                break;
            }
            case R.id.btn_reg:{
                MyDialog.loginDialog.hide();
                MyDialog.regDialog.show();
                Button btn_reg_back = (Button)MyDialog.regDialog.findViewById(R.id.btn_reg_back);
                Button btn_reg_q = (Button)MyDialog.regDialog.findViewById(R.id.btn_reg_q);
                btn_reg_back.setOnClickListener(this);
                btn_reg_q.setOnClickListener(this);
                break;
            }
            case R.id.btn_login_q:{
                MyDialog.loginDialog.cancel();
                EditText edi_account = (EditText)MyDialog.loginDialog.findViewById(R.id.edit_login_account);
                EditText edi_password = (EditText)MyDialog.loginDialog.findViewById(R.id.edit_login_password);
                CheckBox cb_login_save = (CheckBox)MyDialog.loginDialog.findViewById(R.id.cb_login_save);
                UserSetting.setUserLoginInfo(mActivity, edi_account.getText().toString(), edi_password.getText().toString());
                Map<String,String> map = UserSetting.getUserLoginInfo(mActivity);
                //Toast.makeText(mActivity,map.get("account"), Toast.LENGTH_SHORT).show();
                CheckUtil.setUserLoginState(mActivity);
                if(!cb_login_save.isChecked()) {
                    UserSetting.setUserLoginInfo(mActivity, "", "");
                }
                edi_account.setText("");
                edi_password.setText("");
                cb_login_save.setChecked(false);
                break;
            }
            case R.id.btn_reg_back:{
                MyDialog.regDialog.hide();
                MyDialog.loginDialog.show();
                break;
            }
            case R.id.btn_reg_q:{
                MyDialog.regDialog.cancel();
                MyDialog.loginDialog.show();
                EditText edi_name = (EditText)MyDialog.regDialog.findViewById(R.id.edit_reg_name);
                EditText edi_account = (EditText)MyDialog.regDialog.findViewById(R.id.edit_reg_account);
                EditText edi_password = (EditText)MyDialog.regDialog.findViewById(R.id.edit_reg_password);
                EditText edi_password2 = (EditText)MyDialog.regDialog.findViewById(R.id.edit_reg_password2);

                String user = edi_name.getText().toString()+"\n"+edi_account.getText().toString()+"\n"
                        +edi_password.getText().toString()+"\n"+ DataUtil.getMd5(edi_password2.getText().toString());
                Toast.makeText(mActivity, user, Toast.LENGTH_SHORT).show();
                edi_name.setText("");
                edi_account.setText("");
                edi_password.setText("");
                edi_password2.setText("");
                break;
            }

        }
    }
}
