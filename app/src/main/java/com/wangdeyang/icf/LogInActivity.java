package com.wangdeyang.icf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;


public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        configureLogInButton();
    }



    private void configureLogInButton() {
        Button logInButton = findViewById(R.id.logIn);
        EditText idText = findViewById(R.id.patientID);
        EditText nameText = findViewById(R.id.patientName);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update DB
                if (loginPatient(v)) {
                    startActivity(new Intent(LogInActivity.this, MainActivity.class));
                }
            }
        });
    }

    // Login patient with his/her id and name, error return false
    public boolean loginPatient(View view) {
        // CHECK NAME INPUT
        EditText nameText = findViewById(R.id.patientName);
        String name = nameText.getText().toString();

        // Case 1: name empty
        if (name.length() == 0 && name.length() > 20) {
            errorRender("Please enter a valid name.");
            return false;
        }

        // Case 2: name contains number
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ') {
                errorRender("Name can only contain alphabet.");
                return false;
            }
        }

        // ID
        EditText idText = findViewById(R.id.patientID);
        String idStr = idText.getText().toString();
        // Case 3: ID empty
        if (idStr.length() == 0 && idStr.length() > 8) {
            errorRender("Please enter a valid ID.");
            return false;
        }

        // Case 4: ID special characterr
        for (int i = 0; i < idStr.length(); i++) {
            if (!Character.isDigit(idStr.charAt(i))) {
                errorRender("ID can only contain number.");
                return false;
            }
        }

        int id = Integer.parseInt(idText.getText().toString());


        // Check input
        Log.d("Login", "Patient with id-" + id + " and name-" + name + " are logged in.");


        // Connect to DB
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        // Add patient to DB
        Patient patient = new Patient(id, name);
        dbHandler.addHandler(patient);

        // Check updated DB
        Log.d("login", dbHandler.loadHandler());

        // successfully return true
        return true;
    }

    // helper method to renfer error info
    public void errorRender(String str) {
        Toast t = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
        // at the end of the module
        startActivity(new Intent(LogInActivity.this, LogInActivity.class));
    }
}
