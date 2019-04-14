package com.wangdeyang.icf;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EduActivity extends AppCompatActivity {

    List<String> lesson = new ArrayList<String>();
    private Button preButton;
    private int count = -1;

    // Fields for speaker
    private TextToSpeech mTTS;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu);

        configureSubmitButton();
        lesson.add("You may get better or have symptoms improve by taking the study drug.  There are no promises that you will get good results by being in this study. \n");
        lesson.add( "The study sponsor will provide the investigational drug, STUDY DRUG CX-012, at no cost.  You and/or your insurance company are responsible for the costs of any other treatments, \n");
        lesson.add( "Future patients with the same disease may benefit from the results of this study. \n");
        lesson.add("You will receive no payment for taking part in this study.\n");
        lesson.add("There are risks involved in taking STUDY DRUG CX-012. There may be side effects, some of which are not yet known. Problems which have not been seen before may be serious or deadly.");


        configureNextButton();
        configurePreButton();

        mButtonSpeak = findViewById(R.id.button_speak);



        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });



        mEditText = findViewById(R.id.Lesson);
        mSeekBarPitch = findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed = findViewById(R.id.seek_bar_speed);

        mEditText.setEnabled(false);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });


    }

    private void configureSubmitButton() {
        Button takeButton = findViewById(R.id.GoToQuiz);
        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EduActivity.this, Q1.class));
            }

        });

    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.NextLesson);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count< lesson.size()-1){
                    count++;
                }
//                else{
//                    Toast.makeText(EduActivity.this,
//                            "no more questions", Toast.LENGTH_LONG).show();
//                }
                EditText editText = (EditText)findViewById(R.id.Lesson);
                editText.setText(lesson.get(count), TextView.BufferType.EDITABLE);

            }

        });
    }

    private void configurePreButton() {
        preButton = findViewById(R.id.preButton);
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0){
                    count--;
                }
//                else{
//                    Toast.makeText(EduActivity.this,
//                            "this is the first question", Toast.LENGTH_LONG).show();
//                }
                EditText editText = (EditText)findViewById(R.id.Lesson);
                editText.setText(lesson.get(count), TextView.BufferType.EDITABLE);
            }

        });

    }



    private void speak() {
        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
