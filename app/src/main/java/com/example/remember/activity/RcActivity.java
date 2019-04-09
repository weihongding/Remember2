package com.example.remember.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.remember.R;
import com.example.remember.adapter.RcWeekDayAdapter;
import com.example.remember.entity.Rc_q;

import java.util.ArrayList;
import java.util.List;

public class RcActivity extends AppCompatActivity {

    private List<Rc_q> rcqlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        iniRcqList();//初始化数据
        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.recycler_rc_week_day1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        RcWeekDayAdapter adapter = new RcWeekDayAdapter(rcqlist);
        recyclerView1.setAdapter(adapter);
    }

    private void iniRcqList(){
        Rc_q rcq1 = new Rc_q();
        rcq1.setStartTime("2019-4-8 15:03:59");
        rcq1.setColor("#ff0000");
        Rc_q rcq2 = new Rc_q();
        rcq2.setStartTime("2019-4-8 21:35:03");
        rcq2.setColor("#00ff00");
        rcqlist.add(rcq2);
        rcqlist.add(rcq1);
        rcqlist.add(rcq2);
        rcqlist.add(rcq1);
    }

}
