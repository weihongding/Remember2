package com.example.remember.listener;

import android.app.Activity;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.remember.R;

public class RcBtnListener implements View.OnClickListener  {

    private Activity mActivity;

    public RcBtnListener(Activity activity){
        mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_rc_add:{
                View layout_rc_add = (View)mActivity.findViewById(R.id.layout_rc_add);
                View layout_rc_unq = (View)mActivity.findViewById(R.id.layout_rc_unq);
                layout_rc_add.setVisibility(View.GONE);
                layout_rc_unq.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.btn_rc_change:{
                View layout_rc_add = (View)mActivity.findViewById(R.id.layout_rc_add);
                View layout_rc_unq = (View)mActivity.findViewById(R.id.layout_rc_unq);
                layout_rc_add.setVisibility(View.VISIBLE);
                layout_rc_unq.setVisibility(View.GONE);
                break;
            }
            case R.id.btn_rc_history:{
                Toast.makeText(mActivity, "点击了同步", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
