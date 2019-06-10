package com.example.lenovo.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.model.User;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private ImageView avatar;
    private TextView task;

    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        task = itemView.findViewById(R.id.task);
    }

    public void bind(User user) {
        task.setText(user.getTask());
    }
}
