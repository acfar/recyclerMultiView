package com.example.lenovo.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.databinding.TodoListBinding;
import com.example.lenovo.recyclerview.model.User;

public class TodoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    User user;
    private TodoListBinding binding;
    OnItemClickListener myListener;

    public TodoViewHolder(@NonNull TodoListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }



    public void bind(User user, OnItemClickListener myListener ) {

        binding.setUser(user);
        this.user = user;
        this.myListener = myListener;
        binding.getRoot().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        myListener.onItemClick(user);
    }
}
