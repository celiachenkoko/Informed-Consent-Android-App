package com.wangdeyang.icf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q1 extends q {
    private RadioButton chkIos, chkIos2, chkIos3;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q1");
    }

    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q1.this, Q2.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[0]++;
                    String str = "This is a research study for non-Hodgkin’s lymphoma. The purpose is to determine if the study drug will reduce or prevent the cancer cells from growing and if the study drug is safe.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q1.this, Q1.class));
                }
            }
        });
    }

    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton1);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton2);
        chkIos3 = (RadioButton) findViewById(R.id.radioButton3);


        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((RadioButton) v).isChecked()) {
                    ans = 1;
                    configureNextButton();

                }
            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureNextButton();

                }

            }
        });

        chkIos3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureNextButton();

                }
            }
        });
    }
}