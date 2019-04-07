package com.example.remember.util;

import android.content.Context;
import android.graphics.Typeface;

//设置font
public class FontManager {


    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

}
