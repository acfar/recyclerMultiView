package com.example.lenovo.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.databinding.DonetodoListBinding;
import com.example.lenovo.recyclerview.model.User;

public class DoneTodoViewHolder extends RecyclerView.ViewHolder {
    private DonetodoListBinding binding;
//    private ImageView avatar;
//    private TextView name;
//    private CheckBox done;


    public DoneTodoViewHolder(@NonNull DonetodoListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(User user) {

    binding.setUser(user);
    }
}
