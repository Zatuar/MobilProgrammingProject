package com.example.mobilprogrammingproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private String[] mItems;

    MyAdapter(String[] items) {
        mItems = items;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String key = mItems[position];
        holder.textView.setText(key);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }
}