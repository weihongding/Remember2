package com.example.remember.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remember.R;
import com.example.remember.Util.CheckUtil;
import com.example.remember.Util.MyDialog;
import com.example.remember.Util.UserSetting;
import com.example.remember.listener.MaBtnListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_share = (Button)findViewById(R.id.btn_mail);
        Button btn_set = (Button)findViewById(R.id.btn_set);
        Button btn_rc = (Button)findViewById(R.id.btn_rc);
        Button btn_bwl = (Button)findViewById(R.id.btn_bwl);
        Button btn_jl = (Button)findViewById(R.id.btn_jl);
        Button btn_tq = (Button)findViewById(R.id.btn_tq);
        Button btn_dt = (Button)findViewById(R.id.btn_dt);
        Button btn_sb = (Button)findViewById(R.id.btn_sb);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        View logView = this.getLayoutInflater().inflate(R.layout.login, null);
        View regView = this.getLayoutInflater().inflate(R.layout.register, null);

        TextView tv_user = (TextView)findViewById(R.id.text_user);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");

        btn_share.setTypeface(font);
        btn_set.setTypeface(font);
        MaBtnListener listener = new MaBtnListener(this);

        btn_share.setOnClickListener(listener);
        btn_set.setOnClickListener(listener);
        btn_rc.setOnClickListener(listener);
        btn_bwl.setOnClickListener(listener);
        btn_jl.setOnClickListener(listener);
        btn_tq.setOnClickListener(listener);
        btn_dt.setOnClickListener(listener);
        btn_sb.setOnClickListener(listener);
        btn_login.setOnClickListener(listener);
        MyDialog.loginDialog=new MyDialog(this, logView, R.style.DialogTheme);
        MyDialog.regDialog=new MyDialog(this, regView, R.style.DialogTheme);
        MyDialog.loginDialog.setCancelable(true);
        MyDialog.regDialog.setCancelable(true);

        CheckUtil.setUserLoginState(this);

    }

    @Override
    protected void onDestroy() {
        MyDialog.loginDialog.dismiss();
        MyDialog.regDialog.dismiss();
        super.onDestroy();
    }
}
