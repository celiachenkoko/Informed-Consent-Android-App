package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q8 extends q {
    private RadioButton chkIos, chkIos2;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q8);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q8");
    }

    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q8);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q8.this, Q9.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[7]++;
                    String str = "The study drug is a tablet that is taken by mouth with water.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q8.this, Q8.class));
                }
            }
        });
    }

    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton19);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton20);

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
                    ans = 1;
                    configureNextButton();

                }

            }
        });

    }
}