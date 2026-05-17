package com.example.qimendunjia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimendunjia.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private String[] numbers;
    private String[] gongNames;

    public GridAdapter(String[] numbers, String[] gongNames) {
        this.numbers = numbers;
        this.gongNames = gongNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvGongName.setText(gongNames[position]);
        holder.tvNumber.setText(numbers[position]);
    }

    @Override
    public int getItemCount() {
        return numbers.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGongName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGongName = itemView.findViewById(R.id.tvGongName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}