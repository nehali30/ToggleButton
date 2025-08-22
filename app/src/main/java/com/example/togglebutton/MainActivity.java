package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton weatherToggle;
    ImageView weatherImage;
    TextView weatherText;
    LinearLayout mainLayout;
    Button openTipsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherToggle = findViewById(R.id.weatherToggle);
        weatherImage = findViewById(R.id.weatherImage);
        weatherText = findViewById(R.id.weatherText);
        mainLayout = findViewById(R.id.mainLayout);
        openTipsBtn = findViewById(R.id.openTipsBtn);

        weatherToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Rainy Mode
                mainLayout.setBackgroundColor(Color.parseColor("#B3E5FC")); // light blue
                weatherImage.setImageResource(R.drawable.rain);
                weatherText.setText("Don't Forget Your Umbrella!");
            } else {
                // Sunny Mode
                mainLayout.setBackgroundColor(Color.parseColor("#FFF59D")); // light yellow
                weatherImage.setImageResource(R.drawable.sun);
                weatherText.setText("It's A Bright Sunny Day !");
            }
        });

        openTipsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WeatherTips.class);
            intent.putExtra("mode", weatherToggle.isChecked() ? "rainy" : "sunny");
            startActivity(intent);
        });
    }
}