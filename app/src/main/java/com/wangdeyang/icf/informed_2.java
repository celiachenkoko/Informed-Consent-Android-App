package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class informed_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informed_2);
        configureNextButton();
    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.btnDoMagic);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(informed_2.this, education_3.class));
            }

        });

    }
}
