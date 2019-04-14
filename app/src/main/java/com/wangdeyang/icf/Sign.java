package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Sign extends AppCompatActivity {
    private RadioButton chkIos, chkIos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        configureSubmitButton();
    }

    private void configureSubmitButton(){
        Button nextButton=findViewById(R.id.submit);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign.this, LogInActivity.class));
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

                    configureSubmitButton();

                }

            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((RadioButton) v).isChecked()) {
                    configureSubmitButton();

                }

            }
        });
  }
}

