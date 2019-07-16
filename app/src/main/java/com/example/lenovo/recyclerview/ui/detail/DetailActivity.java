package com.example.lenovo.recyclerview.ui.detail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.recyclerview.R;
import com.example.lenovo.recyclerview.databinding.ActivityDetailBinding;
import com.example.lenovo.recyclerview.model.User;
import com.example.lenovo.recyclerview.ui.list.ListActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);
        String todo = getIntent().getExtras().getParcelable("user");
//        binding.setUser(todo);
//        binding.edit.setOnClickListener(this);
        Toast.makeText(DetailActivity.this,todo,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.edit) {
            String name = binding.name.getText().toString().trim();
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("user", new User(name,false));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
