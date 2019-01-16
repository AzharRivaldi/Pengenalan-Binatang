package com.example.aldhiramdans.binatang.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class AbelRegularTextView extends android.support.v7.widget.AppCompatTextView {


    public AbelRegularTextView(Context context) {
        super(context);
        setCustomTypeFace(context);
    }

    public AbelRegularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeFace(context);
    }

    public AbelRegularTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomTypeFace(context);
    }

    private void setCustomTypeFace(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Abel-Regular.ttf");
        this.setTypeface(typeface);
    }
}
