package com.example.lenovo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.example.lenovo.recyclerview.adapter.TodoAdapter;
import com.example.lenovo.recyclerview.model.User;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView users;
    EditText inputTask;
    Button enterTask;
    List<User> user = new ArrayList<>();
    CheckBox cbyes;
    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = findViewById(R.id.main_rcv_todo);
        inputTask = findViewById(R.id.inputTask);
        enterTask = findViewById(R.id.buttonTask);
        cbyes =   findViewById(R.id.checkbox);


        enterTask.setOnClickListener(this);
        initList();
    }

    private void initList() {



        adapter = new TodoAdapter(user);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.users.setLayoutManager(layoutManager);
        this.users.setAdapter(adapter);




    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonTask) {
            adapter.add(new User(inputTask.getText().toString(), cbyes.isChecked()));

        }
    }
}

