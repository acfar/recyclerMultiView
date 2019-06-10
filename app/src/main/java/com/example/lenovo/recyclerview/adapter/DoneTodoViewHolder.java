package com.example.lenovo.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.model.User;

public class DoneTodoViewHolder extends RecyclerView.ViewHolder {
    private ImageView avatar;
    private TextView name;
    private CheckBox done;

    public DoneTodoViewHolder(@NonNull View itemView) {
        super(itemView);

        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.task);
        done = itemView.findViewById(R.id.done);
    }

    public void bind(User user) {
        name.setText(user.getTask());
        done.setChecked(user.isDone());
    }
}
