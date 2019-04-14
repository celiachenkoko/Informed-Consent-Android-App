package com.wangdeyang.icf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q2 extends q {
    private RadioButton chkIos, chkIos2, chkIos3;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        //curr = qList.indexOf("Q2");
        addListenerOnChkIos();
    }

    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q2.this, Q3.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[1]++;
                    String str = "You will have to return to the study site every 4 weeks. At that time, your health will be checked and your ability to perform daily activities.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q2.this, Q2.class));
                }
            }
        });
    }

    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton4);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton5);
        chkIos3 = (RadioButton) findViewById(R.id.radioButton3);


        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureNextButton();

                }

            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((RadioButton) v).isChecked()) {
                    ans = 1;
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