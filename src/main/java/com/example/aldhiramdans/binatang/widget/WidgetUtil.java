package com.example.aldhiramdans.binatang.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WidgetUtil {

    public static void setHeight(Activity activity, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = displayMetrics.heightPixels / 2;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    public static void setHeightByWidth(Activity activity, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = displayMetrics.widthPixels / 2;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    public static boolean validateField(TextView view) {
        if (!TextUtils.isEmpty(view.getText())) {
            return true;
        } else {
            view.requestFocus();
            return false;
        }
    }

    public static int dpToPx(Context context, int dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()));
    }

    public static boolean isAdmin(TextView username, TextView password) {
        if (username.getText().toString().equalsIgnoreCase("admin")
                && password.getText().toString().equalsIgnoreCase("admin")) {
            return true;
        }
        return false;
    }

    private void setViewHeight(Activity activity, View view) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels / 3 - 20;
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
            view.requestLayout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
