package com.example.recyclerviewapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<User> myList;
    Activity mainAct;

    public RecyclerViewAdapter(List<User> myList, Activity mainAct) {
        this.myList = myList;
        this.mainAct = mainAct;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtViewRV;
        User data;
        public MyViewHolder(final View view){
            super(view);
            txtViewRV = view.findViewById(R.id.txtViewDisplay);

        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data = myList.get(position);
        holder.txtViewRV.setText("Name: " + holder.data.getName() + ", Age: " + String.valueOf(holder.data.getAge()));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


}
