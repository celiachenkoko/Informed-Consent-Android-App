package com.wangdeyang.icf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Summary extends q {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        TextView text = (TextView) findViewById(R.id.textView2);

        text.setText("Times getting a wrong answer for each question: ");
        for (int i = 0; i < cList.length; i++) {
            String s = cList[i].toString();
            text.append("\n");
            text.append("Q" + Integer.toString(i+1) + ": "+ s);
        }
        configureSubmitButton();
    }

    private void configureSubmitButton(){
        Button nextButton=findViewById(R.id.sub);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Summary.this, Sign.class));
                }
            });
        }

    }
