package com.example.javabridgemonitoring.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javabridgemonitoring.R;
import com.example.javabridgemonitoring.model.Sistem;

import java.util.List;

public class SistemAdapter extends RecyclerView.Adapter<SistemAdapter.SistemViewHolder> {
    public List<Sistem> dataList;
    public Context context;

    public SistemAdapter(Context context, List<Sistem>dataList){
        this.context = context;
        this.dataList = dataList;
    }
    class SistemViewHolder extends RecyclerView.ViewHolder{
        public  View mView;

        TextView sistemName;
        TextView sistemId;

        SistemViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            sistemName = mView.findViewById(R.id.sistem_name);
            sistemId = mView.findViewById(R.id.sistem_id);
        }
    }

    @NonNull
    @Override
    public SistemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_sistem, parent, false);
        return new SistemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SistemViewHolder holder, int position) {
        holder.sistemName.setText(dataList.get(position).getSistemName());
        holder.sistemId.setText(dataList.get(position).getSistemId());
    }

    @Override
    public int getItemCount() {
        return dataList == null ?0 : dataList.size();
    }
}
