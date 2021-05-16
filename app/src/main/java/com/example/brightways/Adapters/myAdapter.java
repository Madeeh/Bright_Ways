package com.example.brightways.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brightways.Models.model;
import com.example.brightways.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<model, myAdapter.myViewHolder> {
    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.title.setText(model.getTitle());
        holder.category.setText(model.getCategory());
        holder.price.setText(model.getPrice());
        Glide.with(holder.img.getContext()).load(model.getPImage()).into(holder.img);


    } // End of OnBindViewMethod


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }


    static class myViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title, category, price;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            title = itemView.findViewById(R.id.nameText);
            category = itemView.findViewById(R.id.courseText);
            price = itemView.findViewById(R.id.emailText);

        }
    }

}
