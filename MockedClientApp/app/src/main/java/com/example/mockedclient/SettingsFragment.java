package com.example.mockedclient;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.ScaleGestureDetector;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

public class SettingsFragment extends PreferenceFragmentCompat {
    SwitchPreferenceCompat magnifyingZoomSwitch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SwitchPreferenceCompat vibrateSwitch = (SwitchPreferenceCompat) findPreference("vibration");

        if (vibrateSwitch != null) {
            vibrateSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference arg0, Object isVibrateOnObject) {
                    boolean isVibrateOn = (Boolean) isVibrateOnObject;
                    if (isVibrateOn) {
                        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(400);
                        Toast.makeText(getContext(), "VIBRATING", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "NOT VIBRATING", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });
        }
    }


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    public class PinchZoomListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            magnifyingZoomSwitch = (SwitchPreferenceCompat) findPreference("magnifyingZoom");

            if (magnifyingZoomSwitch != null) {
                magnifyingZoomSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference arg0, Object isMagnifyingZoomOnObject) {
                        boolean isMagnifyingZoomOn = (Boolean) isMagnifyingZoomOnObject;
                        if (isMagnifyingZoomOn) {
                            ScaleGestureDetector detector = null;
                            float gesturefactor = detector.getScaleFactor();
                            if (gesturefactor > 1) {
                                Toast.makeText(getContext(), "NOT ZOOMING", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "ZOOMING IN", Toast.LENGTH_SHORT).show();
                            }


                        }
                        return true;
                    }
                });
            }
            return true;


        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
        }

    }
}
