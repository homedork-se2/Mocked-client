package com.example.mockedclient;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Settings");

        if (findViewById(R.id.idFrameLayout) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFragmentManager().beginTransaction().replace(R.id.idFrameLayout, new SettingsFragment()).commit();
        }
    }
}