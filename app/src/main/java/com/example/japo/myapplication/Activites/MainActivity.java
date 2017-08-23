package com.example.japo.myapplication.Activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.japo.myapplication.Model.User;
import com.example.japo.myapplication.R;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.japo.myapplication.MESSAGE";
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean logged = settings.getBoolean("logged", false);

        if (logged == true){
            String usuario = settings.getString("user", null);
            User tempUser = new User(usuario);

            Intent intent = new Intent(this, Operar.class);
            intent.putExtra("currentUser", tempUser);
            startActivity(intent);
        } else{
            //DO Nothing
        }


    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, Operar.class);
        EditText editText = (EditText) findViewById(R.id.user_name);
        String userName = editText.getText().toString();
        EditText editPass = (EditText) findViewById(R.id.user_password);
        String userPassTxt = editPass.getText().toString();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String sharedUser = settings.getString("user", null);
        String sharedPass = settings.getString("password", null);

        if (sharedPass.equals(userPassTxt) && sharedUser.equals(userName)){
            //Logged == true
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("logged", true);
            editor.commit();
            User user = new User(userName);
            intent.putExtra("currentUser", user);
            startActivity(intent);
            Log.d("DEV", "Button pressed -  Name: " + userName);
        } else{
            Context context = getApplicationContext();
            CharSequence text = "Error Signin in";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }





    }

    public void signIn(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        //EditText editText = (EditText) findViewById(R.id.user_name);
        //String userName = editText.getText().toString();
        //User user = new User(userName);
        //intent.putExtra("currentUser", user);
        startActivity(intent);
        //Log.d("DEV", "Button pressed -  Name: " + userName);
    }
}
