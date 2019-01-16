package com.example.aldhiramdans.binatang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldhiramdans.binatang.Controller;
import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.listener.BaseListener;
import com.example.aldhiramdans.binatang.listener.OnItemClickListener;
import com.example.aldhiramdans.binatang.model.HewanModel;
import com.example.aldhiramdans.binatang.model.Temp;
import com.example.aldhiramdans.binatang.widget.GridSpacingItemDecoration;
import com.example.aldhiramdans.binatang.widget.WidgetUtil;

import java.util.ArrayList;

public class ItemListActivity extends BaseActivity implements BaseListener<HewanModel> {
    private ItemListAdapter adapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Controller controller;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_base_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.toolbar);
        setupToolbar(toolbar, Temp.type);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new ItemListAdapter(this);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int pos) {
                Temp.hewanModel = adapter.getItem(pos);
                startActivity(new Intent(ItemListActivity.this, DetailItemActivity.class));
            }
        });
        controller = new Controller(this);
        controller.getData();
        setupRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, WidgetUtil.dpToPx(this, 0), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void setHeight(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = displayMetrics.heightPixels / 4;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    @Override
    public void onSuccess(ArrayList<HewanModel> results) {
        adapter.addItem(results);
    }

    @Override
    public void onError(Throwable e) {

    }
}
