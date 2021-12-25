package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<User> myList = new ArrayList<User>();

    EditText txtName;
    EditText txtAge;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListItems();
        btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName = findViewById(R.id.editTxtName);
                txtAge = findViewById(R.id.editTxtAge);
                String name = txtName.getText().toString();
                int age = Integer.valueOf(txtAge.getText().toString());
                myList.add(new User(name,age));
                setView();
            }
        });
    }

    private void setListItems() {
        User u0 = new User("Ali", 15);
        User u1 = new User("Zahid", 17);
        User u2 = new User("Fawad", 14);
        User u3 = new User("Farhan", 16);
        User u4 = new User("Bilal", 15);
        User u5 = new User("Habib", 17);
        User u6 = new User("Iftikhar", 11);
        User u7 = new User("Alisha", 16);

        myList.addAll(Arrays.asList(new User[]{u0,u1,u2,u3,u4,u5,u6,u7}));
        setView();
    }
    private void setView(){
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(myList,this);

        recyclerView.setAdapter(adapter);
    }

}