package com.example.remember.Util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.remember.R;

public class MyDialog extends Dialog {

    public static MyDialog loginDialog;
    public static MyDialog regDialog;

    //    style引用style样式
    public MyDialog(Context context, View layout, int style) {

        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }
}