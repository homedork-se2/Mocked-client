package com.example.mockedclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ContrastActivity extends AppCompatActivity {

    Switch highContrastSwitch;
    TextView highContrastTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.MockedClient); // Default app theme
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrast);

        highContrastSwitch = findViewById(R.id.highContrastSwitch);
        highContrastTextView = findViewById(R.id.highContrastTextView);

        // Handle high contrast switch
        highContrastSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                System.out.println("HIGH CONTRAST TRUE");
                // Enable contrast mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                System.out.println("HIGH CONTRAST FALSE");
                // Enable normal mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }
}