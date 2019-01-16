package com.example.aldhiramdans.binatang.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.example.aldhiramdans.binatang.R;


public abstract class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new android.transition.Explode());
        }
        setContentView(getLayoutId());
        setupProgressBar();
    }

    protected abstract int getLayoutId();

    public void setupToolbar(Toolbar toolbar) {
        toolbar.setTitle("");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        setSupportActionBar(toolbar);
    }

    public void setupToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        setSupportActionBar(toolbar);
    }

    public void setupProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void showAlertDialog(String message, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setMessage(message);
        if (positiveListener != null)
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", positiveListener);
        if (negativeListener != null)
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL", negativeListener);
        dialog.show();
    }

}
