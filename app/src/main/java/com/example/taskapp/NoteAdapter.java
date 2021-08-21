package com.example.taskapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.databinding.NoteItemBinding;
import com.example.taskapp.model.TaskModel;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {
    NoteItemBinding binding;
    ArrayList<TaskModel> list = new ArrayList<>();

    public void addText(TaskModel text) {
        list.add(text);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = NoteItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private void onBind(TaskModel model){
            binding.itemTitle.setText(model.getTitle());
        }
    }
}