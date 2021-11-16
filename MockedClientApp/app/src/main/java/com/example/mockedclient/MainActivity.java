package com.example.mockedclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        settingsButton.setOnClickListener(v -> {
            // opening a new intent to open settings activity.
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}