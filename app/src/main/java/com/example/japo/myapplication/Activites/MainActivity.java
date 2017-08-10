package com.example.japo.myapplication.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.japo.myapplication.Model.User;
import com.example.japo.myapplication.R;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.japo.myapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, Operar.class);
        EditText editText = (EditText) findViewById(R.id.user_name);
        String userName = editText.getText().toString();
        User user = new User(userName);
        intent.putExtra("currentUser", user);
        startActivity(intent);
        Log.d("DEV", "Button pressed -  Name: " + userName);
    }
}
