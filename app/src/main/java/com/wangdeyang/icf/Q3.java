package com.wangdeyang.icf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q3 extends q {
    private RadioButton chkIos, chkIos2, chkIos3;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q3");
    }

    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q3.this, Q4.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[2]++;
                    String str = "The study drug may have adverse reactions (risks) such as pain in the joints, an increased chance of getting an infection.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q3.this, Q3.class));
                }
            }
        });
    }


    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton3);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton8);
        chkIos3 = (RadioButton) findViewById(R.id.radioButton9);

        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 1;
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
                    ans = 0;
                    configureNextButton();

                }

            }
        });
    }
}