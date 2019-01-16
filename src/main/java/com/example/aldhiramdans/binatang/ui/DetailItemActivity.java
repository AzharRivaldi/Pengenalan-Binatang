package com.example.aldhiramdans.binatang.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.model.Temp;

import java.io.IOException;

public class DetailItemActivity extends BaseActivity {
    private ImageView ivHewan;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private MediaPlayer mediaPlayer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_item_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appBarLayout = findViewById(R.id.appbar);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ivHewan = findViewById(R.id.iv_hewan);
        tvTitle = findViewById(R.id.tv_title);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(Temp.hewanModel.getJenis().toLowerCase(), Temp.hewanModel.getSuara());
            }
        });

        tvSubtitle = findViewById(R.id.tv_subtitle);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp));
        setSupportActionBar(toolbar);
        setHeight(appBarLayout);

        if (Temp.hewanModel != null) {
            Glide.with(this).load(Temp.hewanModel.getGambar()).into(ivHewan);
            tvTitle.setText(Temp.hewanModel.getNama());
            tvSubtitle.setText(Temp.hewanModel.getTextEn());
            Glide.with(this).load(Temp.hewanModel.getGambar()).into(ivHewan);
        }
    }

    @Override
    protected void onResume() {
        mediaPlayer = new MediaPlayer();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    private void playSound(String type, String filename) {
        try {
            mediaPlayer.reset();
            AssetFileDescriptor asset = getAssets().openFd(type + "/" + filename + ".mp3");
            mediaPlayer.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHeight(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = displayMetrics.heightPixels / 2;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
