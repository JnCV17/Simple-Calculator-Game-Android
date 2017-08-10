package com.example.japo.myapplication.Model;

import java.io.Serializable;

/**
 * Created by Japo on 8/08/17.
 */

public class User implements Serializable {

    String name;
    int count, correct, error;

    public User(String _name){
        name = _name;
        count = 0;
        correct = 0;
        error = 0;
    }

    public void addCount(){
        count = count + 1;
    }

    public void addCorrect(){
        correct = correct + 1;
    }

    public void addError(){
        error = error + 1;
    }

    //GETS missing

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public int getCorrect(){
        return correct;
    }
}
