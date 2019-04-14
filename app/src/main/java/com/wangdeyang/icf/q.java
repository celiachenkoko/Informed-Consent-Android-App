package com.wangdeyang.icf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;


public class q extends AppCompatActivity {
    // store question numbers need to be looped
    //protected static ArrayList<String> qList = new ArrayList<String>(Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9"));
    // store number of times of getting a wrong answer
    protected static Integer[] cList = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    // index of current question in qList
    //protected int curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);
    }
}
