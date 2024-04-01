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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textName, textDesc;
        ImageView imageInfo;

        textName = findViewById(R.id.textName);
        textDesc = findViewById(R.id.textDesc);
        imageInfo = findViewById(R.id.imageInfo);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameInfo");
        String desc = intent.getStringExtra("descInfo");
        String image = intent.getStringExtra("imageInfo");

        textName.setText(name);
        textDesc.setText(desc);

        Glide.with(this)
                .load(image)
                .into(imageInfo);
    }
}