package com.example.aldhiramdans.binatang.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class PacificoRegularTextView extends android.support.v7.widget.AppCompatTextView {


    public PacificoRegularTextView(Context context) {
        super(context);
        setCustomTypeFace(context);
    }

    public PacificoRegularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeFace(context);
    }

    public PacificoRegularTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomTypeFace(context);
    }

    private void setCustomTypeFace(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "pacifico.regular.ttf");
        this.setTypeface(typeface);
    }
}
