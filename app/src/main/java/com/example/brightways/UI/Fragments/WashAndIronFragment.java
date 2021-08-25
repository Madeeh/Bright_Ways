package com.example.brightways.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brightways.Models.PriceListModel;
import com.example.brightways.R;
import com.example.brightways.ViewHolder.PriceListViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WashAndIronFragment extends Fragment {
    DatabaseReference ProductsRef;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    public WashAndIronFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wash_and_iron, container, false);


        ProductsRef = FirebaseDatabase.getInstance().getReference().child("PriceList").child("WashAndIron");


        recyclerView = view.findViewById(R.id.recycler_menuPriceList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<PriceListModel> options =
                new FirebaseRecyclerOptions.Builder<PriceListModel>()
                        .setQuery(ProductsRef, PriceListModel.class)
                        .build();

        FirebaseRecyclerAdapter<PriceListModel, PriceListViewHolder> adapter =
                new FirebaseRecyclerAdapter<PriceListModel, PriceListViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull PriceListViewHolder holder, int position, @NonNull final PriceListModel model) {
                        holder.ItemName.setText(model.getpTitle());
                        holder.ItemPrice.setText(model.getpPrice());

                    }

                    @NonNull
                    @Override
                    public PriceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_price_list, parent, false);
                        PriceListViewHolder holder = new PriceListViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

}