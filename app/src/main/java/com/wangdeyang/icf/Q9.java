package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.TextView;

public class Q9 extends q {
    private RadioButton chkIos, chkIos2;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q9);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q9");
    }
    private void configureSubmitButton(){
        Button nextButton=findViewById(R.id.next_q9);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q9.this, Summary.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[8]++;
                    String str = "Research is for the purpose of finding answers that can be used to benefit society as a whole. The main goal of the study is to summarize your information with others in this study to determine if the drug works and is safe in general.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q9.this, Q9.class));
                }
            }
        });
    }
    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton21);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton22);

        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 1;
                    configureSubmitButton();

                }

            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    ans = 0;
                    configureSubmitButton();

                }

            }
        });

    }
}
