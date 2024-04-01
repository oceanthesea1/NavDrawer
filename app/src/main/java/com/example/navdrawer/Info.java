package com.example.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Info extends AppCompatActivity {

    TextView textName, textDescLong;
    ImageView imageInfo, backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textName = findViewById(R.id.textName);
        textDescLong = findViewById(R.id.textDesc);
        imageInfo = findViewById(R.id.imageInfo);
        backArrow = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameInfo");
        String descLong = intent.getStringExtra("descInfo");
        String image = intent.getStringExtra("imageInfo");

        textName.setText(name);
        textDescLong.setText(descLong);

        Glide.with(this)
                .load(image)
                .into(imageInfo);

        backArrow.setOnClickListener(v -> {
            finish();
        });
    }
}