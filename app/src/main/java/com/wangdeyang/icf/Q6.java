package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Q6 extends q {
    private RadioButton chkIos, chkIos2;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q6);
        addListenerOnChkIos();
        //curr = qList.indexOf("Q6");
    }

    private void configureNextButton(){
        Button nextButton=findViewById(R.id.next_q6);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose the right answer and switch to next question
                if (ans == 1) {
                    startActivity(new Intent(Q6.this, Q7.class));
                }
                // answered wrong, display explanation and start the question again
                else {
                    cList[5]++;
                    String str = "You do not need to be in the study to receive treatment for your condition. If you don't enroll, you can receive the same treatment you would have received.";
                    Toast t = Toast.makeText(getApplicationContext(), "That is incorrect. "+str, Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    // at the end of the module
                    startActivity(new Intent(Q6.this, Q6.class));
                }
            }
        });
    }

    public void addListenerOnChkIos() {

        chkIos = (RadioButton) findViewById(R.id.radioButton16);
        chkIos2 = (RadioButton) findViewById(R.id.radioButton17);

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
