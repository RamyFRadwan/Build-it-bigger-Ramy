package com.ramyfradwan.jokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;


public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "com.ramyfradwan.jokelibrary.JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        String joke = Objects.requireNonNull(intent.getExtras()).getString(JOKE_KEY);
        TextView textView = findViewById(R.id.joke_text);
        textView.setText(joke);
    }
}
