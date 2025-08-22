package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeatherTips extends AppCompatActivity {

    TextView tipsText;
    ImageView tipsIcon;
    LinearLayout layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_tips);

        tipsText = findViewById(R.id.tipsText);
        tipsIcon = findViewById(R.id.tipsIcon);
        layout=findViewById(R.id.l2);

        String mode = getIntent().getStringExtra("mode");

        if ("r ainy".equals(mode)) {
            tipsText.setText("🌧️ Rainy Day Tips:\n• Carry an umbrella\n• Avoid slippery roads\n• Wear waterproof shoes");
            tipsIcon.setImageResource(R.drawable.baseline_umbrella_24);
            layout.setBackgroundColor(Color.parseColor("#B3E5FC")); // light blue

        } else {
            tipsText.setText("☀️ Sunny Day Tips:\n• Wear sunscreen\n• Stay hydrated\n• Use sunglasses");
            tipsIcon.setImageResource(R.drawable.icon_sun);
            layout.setBackgroundColor(Color.parseColor("#FFF59D"));// light yellow
        }
    }
}