package com.example.japo.myapplication.Activites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.japo.myapplication.Activites.MainActivity;
import com.example.japo.myapplication.Model.User;
import com.example.japo.myapplication.R;

public class Operar extends AppCompatActivity {

    int x,y,z,result, answer;
    String operationString;
    User currentUser;
    TextView textView;
    TextView operationTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");

        // Capture the layout's TextView and set the string as its text
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentUser.getName());

        //Get and Set the operation field to show
        operationTxt = (TextView) findViewById(R.id.operacion_txt);
        generateOperation();



    }

    public void validateOperation(View view){
        Log.d("DEV", "Submiting Answer");
        //Get the textfield with the answer
        EditText answerTxt = (EditText) findViewById(R.id.answer_txt);
        answer = Integer.parseInt( answerTxt.getText().toString() );
        Log.d("DEV", "Your answer: "+ answer);
        currentUser.addCount();
        //Correct Answer
        if(answer == result){
          currentUser.addCorrect();
            Context context = getApplicationContext();
            CharSequence text = "Correct";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if(answer != result){
            currentUser.addError();
            Context context = getApplicationContext();
            CharSequence text = "Incorrect";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        //Validates User Count
        validateUserCount();
    }

    public void validateUserCount(){
        if(currentUser.getCount() >=7){
            //Change View
            Log.d("DEV", "Game Ended - UserCount: "+ currentUser.getCount());
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("currentUser", currentUser);
            startActivity(intent);
        } else {
            //Generate new Operation and refresh view
            Log.d("DEV", "Game Refresh - UserCount: "+ currentUser.getCount());
            generateOperation();
        }
    }

    public void generateOperation(){

        //Generate the numbers to operate and give the type of operation
        x = generateRandomNum();
        y = generateRandomNum();
        z = generateRandomOperator();

        //Case for addion operation
        if(z == 1){
            result = x + y;
            operationString = x +" + "+ y + " =";
        }
        //Case for substraction operation
        if(z == 2){
            result = x - y;
            operationString = x +" - "+ y + " =";
        }
        //Case for multiplication operation
        if(z == 3){
            result = x * y;
            operationString = x +" x "+ y + " =";
        }

        operationTxt.setText(operationString);
    }

    public int generateRandomNum(){
        int output;

        output =(int) Math.floor(Math.random() * 100);

        return output;
    }

    public int generateRandomOperator(){
        int output;

        output =(int) Math.ceil(Math.random() * 3);

        return output;
    }

}
