package com.example.remember.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.remember.R;
import com.example.remember.adapter.RcQAdapter;
import com.example.remember.adapter.RcUnqAdapter;
import com.example.remember.entity.Rc_q;
import com.example.remember.entity.Rc_unq;
import com.example.remember.listener.RcBtnListener;

import java.util.ArrayList;
import java.util.List;

public class RcActivity extends AppCompatActivity {

    private List<Rc_q> rcqlist1 = new ArrayList<>();
    private List<Rc_q> rcqlist2 = new ArrayList<>();
    private List<Rc_unq> rcUnqList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        iniRcqList();//初始化数据
        iniRcUnqList();//初始化数据

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        RcBtnListener listener = new RcBtnListener(this);

        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recycler_rc_q1);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_rc_q2);
        RecyclerView recyclerViewUnq = (RecyclerView) findViewById(R.id.recycler_rc_unq);
        Button btn_add = (Button) findViewById(R.id.btn_rc_add);
        Button btn_history = (Button) findViewById(R.id.btn_rc_history);
        Button btn_change = (Button) findViewById(R.id.btn_rc_change);
        btn_history.setTypeface(font);
        btn_change.setTypeface(font);
        btn_add.setOnClickListener(listener);
        btn_history.setOnClickListener(listener);
        btn_change.setOnClickListener(listener);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerUnq = new LinearLayoutManager(this);

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerViewUnq.setLayoutManager(layoutManagerUnq);

        RcQAdapter adapter1 = new RcQAdapter(rcqlist1);
        RcQAdapter adapter2 = new RcQAdapter(rcqlist2);
        RcUnqAdapter adapterUnq = new RcUnqAdapter(rcUnqList);

        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerViewUnq.setAdapter(adapterUnq);

    }

    private void iniRcqList() {
        Rc_q rcq1 = new Rc_q();
        rcq1.setStartTime("2019-4-8 15:03:59");
        rcq1.setColor("#ff0000");
        Rc_q rcq2 = new Rc_q();
        rcq2.setStartTime("2019-4-8 21:35:03");
        rcq2.setColor("#00ff00");
        rcqlist1.add(rcq2);
        rcqlist1.add(rcq1);

        rcqlist2.add(rcq1);
        rcqlist2.add(rcq2);
    }

    private void iniRcUnqList() {
        Rc_unq rcUnq1 = new Rc_unq();
        rcUnq1.setColor("#ff0000");
        Rc_unq rcUnq2 = new Rc_unq();
        rcUnq2.setColor("#00ff00");
        rcUnqList.add(rcUnq1);
        rcUnqList.add(rcUnq2);
    }

}
