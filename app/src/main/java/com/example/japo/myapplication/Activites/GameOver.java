package com.example.japo.myapplication.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.japo.myapplication.Model.User;
import com.example.japo.myapplication.R;

public class GameOver extends AppCompatActivity {
    User currentUser;
    String gameOverText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        //Receive User Object
        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");

        validateWinner();

        TextView endMessage = (TextView) findViewById(R.id.textView5);
        endMessage.setText(gameOverText);

    }

    public void validateWinner(){
        //WINNER!!!!
        if(currentUser.getCorrect()>=4){
            gameOverText = "You've Won!";
        } else{
            gameOverText = "You've Lost";
        }
    }
}
