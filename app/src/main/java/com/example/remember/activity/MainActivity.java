package com.example.remember.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.remember.R;
import com.example.remember.listener.MaBtnListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_share = (Button)findViewById(R.id.btn_share);
        Button btn_set = (Button)findViewById(R.id.btn_set);
        Button btn_rc = (Button)findViewById(R.id.btn_rc);
        Button btn_bwl = (Button)findViewById(R.id.btn_bwl);
        Button btn_jl = (Button)findViewById(R.id.btn_jl);
        Button btn_tq = (Button)findViewById(R.id.btn_tq);
        Button btn_dt = (Button)findViewById(R.id.btn_dt);
        Button btn_sb = (Button)findViewById(R.id.btn_sb);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");

        btn_share.setTypeface(font);
        btn_set.setTypeface(font);
        btn_share.setOnClickListener(new MaBtnListener());
        btn_set.setOnClickListener(new MaBtnListener());
        btn_rc.setOnClickListener(new MaBtnListener());
        btn_bwl.setOnClickListener(new MaBtnListener());
        btn_jl.setOnClickListener(new MaBtnListener());
        btn_tq.setOnClickListener(new MaBtnListener());
        btn_dt.setOnClickListener(new MaBtnListener());
        btn_sb.setOnClickListener(new MaBtnListener());
        btn_login.setOnClickListener(new MaBtnListener());

    }
}
