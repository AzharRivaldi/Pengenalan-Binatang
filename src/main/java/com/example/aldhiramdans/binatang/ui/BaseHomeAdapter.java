package com.example.aldhiramdans.binatang.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aldhiramdans.binatang.Application;
import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.listener.OnItemClickListener;
import com.example.aldhiramdans.binatang.widget.WidgetUtil;

import java.util.ArrayList;

public class BaseHomeAdapter extends RecyclerView.Adapter<BaseHomeAdapter.BaseHomeViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<ItemHome> items;
    private OnItemClickListener listener;

    public BaseHomeAdapter(Activity activity) {
        context = Application.getContext();
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseHomeViewHolder holder = new BaseHomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_home, parent, false));
        holder.setOnItemClickListener(clickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHomeViewHolder holder, int position) {
        ItemHome item = getItemPosition(position);
        WidgetUtil.setHeight(activity, holder.panel);
        holder.tvTitle.setText(item.getTitle());
        holder.ivBackground.setBackground(item.getDrawable());
        holder.tvSubtitle.setText(item.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void addItem(ArrayList<ItemHome> results) {
        if (results != null) {
            items = results;
            notifyDataSetChanged();
        }
    }

    public ItemHome getItemPosition(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener clickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            listener.onItemClick(v, position);
        }
    };

    public void clearAdapter() {
        try {
            context = null;
            items = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class BaseHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RelativeLayout panel;
        public ImageView ivBackground;
        public TextView tvTitle;
        public TextView tvSubtitle;

        private OnItemClickListener itemClickListener;

        public BaseHomeViewHolder(View itemView) {
            super(itemView);
            panel = itemView.findViewById(R.id.image_panel);
            ivBackground = itemView.findViewById(R.id.iv_food);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.itemClickListener = listener;
        }
    }

    public static class ItemHome {
        private String title;
        private String subtitle;
        private Drawable drawable;
        private int color;

        public ItemHome() {
        }

        public ItemHome(String title, String subtitle, Drawable drawable) {
            this.title = title;
            this.subtitle = subtitle;
            this.drawable = drawable;
        }

        public ItemHome(String title, String subtitle, int color) {
            this.title = title;
            this.subtitle = subtitle;
            this.color = color;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }
    }
}