package com.example.lenovo.recyclerview.ui.list;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.adapter.OnItemClickListener;
import com.example.lenovo.recyclerview.adapter.TodoAdapter;
import com.example.lenovo.recyclerview.databinding.ActivityListBinding;
import com.example.lenovo.recyclerview.dialog.AddDialog;
import com.example.lenovo.recyclerview.dialog.AddDialogListener;
import com.example.lenovo.recyclerview.model.User;
import com.example.lenovo.recyclerview.ui.detail.DetailActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener, AddDialogListener, OnItemClickListener {
    ArrayList<User> dataTampung;
    ActivityListBinding binding;
    TodoAdapter adapter;
    String b;
    final int EDIT_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding = DataBindingUtil
//        setContentView(R.layout.activity_list);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
       setSupportActionBar(binding.toolbar);

//        users = findViewById(R.id.main_rcv_todo);
//        inputTask = findViewById(R.id.inputTask);
//        enterTask = findViewById(R.id.buttonTask);
//        cbyes =   findViewById(R.id.checkbox);


        binding.buttonTask.setOnClickListener(this);
        initList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                add();
                return true;
            case R.id.menu_setting:
                setting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void add(){
        Toast.makeText(this,"add", Toast.LENGTH_SHORT).show();
        AddDialog dialog = new AddDialog(this);
        dialog.show();
    }

    private void setting(){
        Toast.makeText(this,"setting", Toast.LENGTH_SHORT).show();
    }

    private void initList() {



        adapter = new TodoAdapter(new ArrayList<User>(), this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvTodo.setLayoutManager(layoutManager);
        this.binding.mainRcvTodo.setAdapter(adapter);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK && requestCode==EDIT_REQUEST_CODE){
            User user = data.getExtras().getParcelable("user");
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonTask) {
            b = binding.inputTask.getText().toString();
            adapter.add(new User(b, binding.checkbox.isChecked()));

        }
    }

    @Override
    public void onAdd(String name) {
        adapter.add(new User(name,false));
    }


    @Override
    public void onItemClick(User item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("user",item.getTask());
//            startActivity(intent);
        startActivityForResult(intent, EDIT_REQUEST_CODE);

    }
}

