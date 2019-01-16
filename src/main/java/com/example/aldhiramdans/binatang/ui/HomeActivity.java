package com.example.aldhiramdans.binatang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.listener.OnItemClickListener;
import com.example.aldhiramdans.binatang.model.Temp;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {
    private BaseHomeAdapter adapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private AppBarLayout appbar;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_base_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        toolbar.setTitle("Pengenalan Hewan");
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new BaseHomeAdapter(this);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                BaseHomeAdapter.ItemHome item = adapter.getItemPosition(pos);
                Temp.type = item.getTitle();
                startActivity(new Intent(HomeActivity.this, ItemListActivity.class));
            }
        });
        setupRecyclerView();
        setupAdapter();
    }

    private void setupAdapter() {
        ArrayList<BaseHomeAdapter.ItemHome> items = new ArrayList<>();
        items.add(new BaseHomeAdapter.ItemHome("Herbivora", "Menampilkan hewan pemakan tumbuhan", getResources().getDrawable(R.drawable.herbivora)));
        items.add(new BaseHomeAdapter.ItemHome("Karnivora", "Menampilkan hewan pemakan daging", getResources().getDrawable(R.drawable.karnivora)));
        items.add(new BaseHomeAdapter.ItemHome("Omnivora", "Menampilkan hewan pemakan tumbuhan dan daging", getResources().getDrawable(R.drawable.omnivora)));
        adapter.addItem(items);
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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
}
