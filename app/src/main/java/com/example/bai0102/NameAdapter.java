package com.example.bai0102;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    private ArrayList<Name> names;
    private Context context;
    private ItemClickListener mItemListener;

    public NameAdapter(ArrayList<Name> names, Context context) {
        this.names = names;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View itemView = inflater.inflate(R.layout.row_item_name, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Name name = this.names.get(position);
        holder.tvName.setText(name.getName());
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(names.get(position));
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.remove(name);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public interface ItemClickListener {
        void onItemClick(Name name);
    }

    public void setOnItemClickListener(ItemClickListener ItemListener){
        this.mItemListener = ItemListener;
    }
}
