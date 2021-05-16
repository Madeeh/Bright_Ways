package com.example.brightways.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brightways.R;

public class CardAdapter  extends RecyclerView.Adapter <CardAdapter.cardViewHolder>{

    private String[] data;
    public CardAdapter(String[] data){
        this.data=data;
    }

    @NonNull
    @Override
    public cardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater
                .inflate(R.layout.card_list_item_layout, parent,false);
        return new cardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewHolder holder, int position) {

        String title = data[position];
        holder.txtShirt.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class cardViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtShirt;
        public cardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtShirt= itemView.findViewById(R.id.txtShirt);
        }
    }
}
