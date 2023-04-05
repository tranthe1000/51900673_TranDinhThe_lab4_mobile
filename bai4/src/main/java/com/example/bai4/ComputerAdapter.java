package com.example.bai4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder>{
    private ArrayList<Computer> computers;
    private Context context;

    public ComputerAdapter(ArrayList<Computer> computers, Context context) {
        this.computers = computers;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPic;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.ivPic);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View itemView = inflater.inflate(R.layout.cell_item_computer, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Computer computer = this.computers.get(position);
        holder.ivPic.setImageResource(computer.getPicAvatar());
        holder.tvName.setText(computer.getName());
        if(computer.isChecked())
        {
            holder.ivPic.setImageResource(R.drawable.monitor_icon_focus);
        }
        else
        {
            holder.ivPic.setImageResource(R.drawable.monitor_icon);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computer.setChecked(!computer.isChecked());
                notifyDataSetChanged();
                if (computer.isChecked()) {
                    Toast.makeText(view.getContext(), computer.getName() + " is ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(view.getContext(), computer.getName() + " is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.computers.size();
    }
}
