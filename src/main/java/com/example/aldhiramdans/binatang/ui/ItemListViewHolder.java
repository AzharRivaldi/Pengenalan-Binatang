package com.example.aldhiramdans.binatang.ui;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aldhiramdans.binatang.R;
import com.example.aldhiramdans.binatang.listener.OnItemClickListener;

public class ItemListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvTitle;
    public CardView panelHolder;
    public ImageView ivIcon;

    private OnItemClickListener listener;

    public ItemListViewHolder(View itemView) {
        super(itemView);
        ivIcon = itemView.findViewById(R.id.iv_icon);
        tvTitle = itemView.findViewById(R.id.tv_title);
        panelHolder = itemView.findViewById(R.id.cardview);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
