package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q4 extends q {
    private RadioButton chkIos, chkIos2, chkIos3;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q4");
    }
    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q4);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q4.this, Q5.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[3]++;
                    String str = "Reimbursement for your time and compensation is intended to be just and fair but are not considered benefits. The benefit to the study is that your condition may get better if the study drug works for you.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q4.this, Q4.class));
                }
            }
        });
    }

    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton10);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton11);
        chkIos3 = (RadioButton) findViewById(R.id.radioButton12);


        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureNextButton();

                }

            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureNextButton();

                }

            }
        });

        chkIos3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 1;
                    configureNextButton();

                }

            }
        });
    }
}