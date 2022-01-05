package com.example.mockedclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnSpeak;
    private TextView tvText;
    protected static final int RESULT_SPEECH= 1;
    private Button DiscoMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_MockedClient); // Default app theme
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView text1 = findViewById(R.id.textView);
        TextView text2 = findViewById(R.id.textView2);
        Button settingsButton = findViewById(R.id.settingsButton);

        tvText = findViewById(R.id.tvText);
        btnSpeak = findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    tvText.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Sorry current device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


        settingsButton.setOnClickListener(v -> {
            // opening a new intent to open settings activity.
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });


        DiscoMood =(Button) findViewById(R.id.button2);
        DiscoMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiscoMoodActivity();
            }
        });

    }

    private void openDiscoMoodActivity() {
        Intent intent = new Intent(this ,DiscoMoodActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tvText.setText(text.get(0));
                }
                break;
        }
    }
}