package com.example.shade;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView shadeDetailTV = (TextView) findViewById(R.id.shade_detail_TV);
        String shadeDetail = getIntent().getStringExtra("shade_detail");
        String shadeColor = getIntent().getStringExtra("shade_color");
        shadeDetailTV.setText(shadeDetail);
        shadeDetailTV.setBackgroundColor(Color.parseColor(String.valueOf(shadeColor)));
    }
}