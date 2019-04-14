package com.wangdeyang.icf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Quiz extends AppCompatActivity {
//    private TextView questionView = findViewById(R.id.editText7);
//    private
    private CheckBox chkIos, chkIos2, chkIos3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView questionView = findViewById(R.id.editText7);
        questionView.setEnabled(false);
//        checkBox2
        addListenerOnChkIos();
    }

    public void addListenerOnChkIos() {

        chkIos = (CheckBox) findViewById(R.id.checkBox);
        chkIos2 = (CheckBox) findViewById(R.id.checkBox2);
        chkIos3 = (CheckBox) findViewById(R.id.checkBox3);


        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(Quiz.this,
                            "Right Answer", Toast.LENGTH_LONG).show();
                }

            }
        });

        chkIos2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(Quiz.this,
                            "Wrong Answer", Toast.LENGTH_LONG).show();
                }

            }
        });

        chkIos3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(Quiz.this,
                            "Wrong Answer", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
