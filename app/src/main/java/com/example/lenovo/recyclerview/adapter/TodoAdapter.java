package com.example.lenovo.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.model.User;
import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users = new ArrayList<>();

    public  TodoAdapter(List<User> users) {

        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 1) {
            return new DoneTodoViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.donetodo_list, viewGroup, false));
        } else {
            return new TodoViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.todo_list, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case 1:
                DoneTodoViewHolder doneViewHolder = (DoneTodoViewHolder) viewHolder;
                doneViewHolder.bind(users.get(position));
                break;
            default:
                TodoViewHolder todoViewHolder = (TodoViewHolder) viewHolder;
                todoViewHolder.bind(users.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return users.get(position).isDone() ? 1 : 0;
    }

    public void add(User todo) {
        users.add(todo);
        notifyItemInserted(users.size()-1);
    }
}
