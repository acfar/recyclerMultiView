package com.example.lenovo.recyclerview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.databinding.DialodAddBinding;

public class AddDialog extends Dialog implements View.OnClickListener {
    DialodAddBinding binding;
    AddDialogListener listener;
    Context context;

    public AddDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public AddDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected AddDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialod_add,
                null, false);
        setContentView(binding.getRoot());

        binding.close.setOnClickListener(this);
        binding.add.setOnClickListener(this);

        if (context instanceof AddDialogListener) {
            listener = (AddDialogListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AddDialogListener");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                close();
                break;
            case R.id.add:
                add();
                break;
        }
    }

    private void close() {
        dismiss();
    }

    private void add() {
        String name = binding.todo.getText().toString().trim();
        listener.onAdd(name);
        close();
    }

}
