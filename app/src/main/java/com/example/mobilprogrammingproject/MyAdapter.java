package com.example.mobilprogrammingproject;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private OnItemClickListener listener;
    private List<Individu> mItems;

    MyAdapter(List<Individu> items, OnItemClickListener listener) {
        this.mItems = items;
        this.listener = listener;
    }
    static class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        Holder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Individu key = mItems.get(position);
        String print=key.getName();
        setFont(holder);
        holder.textView.setText(print);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(key);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private void setFont(Holder holder) {
        try {
            Typeface typeface = Typeface.createFromAsset(holder.itemView.getContext().getAssets(), "font/sevesbrg.ttf");
            holder.textView.setTypeface(typeface);
        } catch (Exception e) {
            Log.e("FONT", "svesbrg.ttf not found", e);
        }
    }
}