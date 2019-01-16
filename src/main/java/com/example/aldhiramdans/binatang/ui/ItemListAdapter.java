package com.example.aldhiramdans.binatang.ui;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.aldhiramdans.binatang.Application;
import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.listener.OnItemClickListener;
import com.example.aldhiramdans.binatang.model.HewanModel;
import com.example.aldhiramdans.binatang.model.Temp;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<HewanModel> items;
    private OnItemClickListener listener;

    public ItemListAdapter(Activity activity) {
        this.activity = activity;
        context = Application.getContext();
        this.items = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        ItemListViewHolder holder = new ItemListViewHolder(view);
        holder.setOnClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                listener.onItemClick(view, pos);
            }
        });
        return holder;
    }

    public void setHeight(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = displayMetrics.widthPixels / 3;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        if (items != null) {
            HewanModel item = getItem(position);
            holder.tvTitle.setText(item.getNama());
            Glide.with(holder.ivIcon.getContext()).load(item.getGambar()).into(holder.ivIcon);
        }
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public HewanModel getItem(int pos) {
        return items.get(pos);
    }

    public void addItem(ArrayList<HewanModel> items) {
        if (items != null) {
            ArrayList<HewanModel> list = new ArrayList<>();
            for (HewanModel rambu : items) {
                if (rambu.getJenis().equalsIgnoreCase(Temp.type)) {
                    list.add(rambu);
                }
            }
            this.items = list;
            notifyDataSetChanged();
        }
    }
}
