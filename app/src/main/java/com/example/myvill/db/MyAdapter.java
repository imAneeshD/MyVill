package com.example.myvill.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvill.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private ArrayList name_id, address_id, phone_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList address_id, ArrayList phone_id) {
        this.context = context;
        this.name_id = name_id;
        this.address_id = address_id;
        this.phone_id = phone_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_contacts, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));
        holder.phone_id.setText(String.valueOf(phone_id.get(position)));
        holder.call.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return name_id.size();
    }






    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, address_id, phone_id;
        ImageView call;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.c_name);
            address_id = itemView.findViewById(R.id.c_address);
            phone_id = itemView.findViewById(R.id.c_phone);
            call = itemView.findViewById(R.id.call);
        }
    }
}
