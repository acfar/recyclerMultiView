package com.example.lenovo.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.example.lenovo.recyclerview.adapter.TodoAdapter;
import com.example.lenovo.recyclerview.databinding.ActivityMainBinding;
import com.example.lenovo.recyclerview.model.User;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    TodoAdapter adapter;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding = DataBindingUtil
        setContentView(R.layout.activity_main);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        users = findViewById(R.id.main_rcv_todo);
//        inputTask = findViewById(R.id.inputTask);
//        enterTask = findViewById(R.id.buttonTask);
//        cbyes =   findViewById(R.id.checkbox);


        binding.buttonTask.setOnClickListener(this);
        initList();
    }

    private void initList() {



        adapter = new TodoAdapter(new ArrayList<User>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvTodo.setLayoutManager(layoutManager);
        this.binding.mainRcvTodo.setAdapter(adapter);




    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonTask) {
            b = binding.inputTask.getText().toString();
            adapter.add(new User(b, binding.checkbox.isChecked()));

        }
    }
}

