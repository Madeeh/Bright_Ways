package com.example.brightways.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.brightways.R;

public class PriceListViewHolder extends RecyclerView.ViewHolder {
    public TextView ItemName;
    public TextView ItemPrice;


    public PriceListViewHolder(View itemView) {
        super(itemView);
        ItemName = itemView.findViewById(R.id.itemName);
        ItemPrice = itemView.findViewById(R.id.itemPrice);
    }
}