package com.example.remember.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.remember.R;
import com.example.remember.entity.Rc_q;
import com.example.remember.entity.Rc_unq;
import com.example.remember.util.DateUtil;

import java.util.List;

public class RcUnqAdapter extends RecyclerView.Adapter<RcUnqAdapter.ViewHolder> {

    private List<Rc_unq> mRcUnqList;

    public RcUnqAdapter(List<Rc_unq> rcUnqList){
        this.mRcUnqList = rcUnqList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_unq_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rc_unq rcUnq = mRcUnqList.get(position);
        String color = rcUnq.getColor();
        GradientDrawable p1 = (GradientDrawable) holder.rcUnq.getBackground();
        p1.setColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return mRcUnqList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rcUnq;

        public ViewHolder(@NonNull View view) {
            super(view);
            rcUnq = (TextView)view.findViewById(R.id.text_rc_unq_item);
        }
    }

}
