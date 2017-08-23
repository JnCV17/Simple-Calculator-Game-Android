package com.example.japo.myapplication.Activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.japo.myapplication.R;

import static com.example.japo.myapplication.Activites.MainActivity.PREFS_NAME;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //EditText editText = (EditText) findViewById(R.id.user_name);
        //String userName = editText.getText().toString();
        //User user = new User(userName);
        //intent.putExtra("currentUser", user);
        startActivity(intent);
        //Log.d("DEV", "Button pressed -  Name: " + userName);
    }

    public void register(View view){


        EditText editText = (EditText) findViewById(R.id.player_txt);
        String userName = editText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.userPas);
        String userPass = passwordText.getText().toString();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("user", userName);
        editor.putString("password", userPass);
        editor.putBoolean("logged", false);

        // Commit the edits!
        editor.commit();

        Context context = getApplicationContext();
        CharSequence text = "User Registred";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
