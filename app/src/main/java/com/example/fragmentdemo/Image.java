package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Image extends AppCompatActivity {

    private ImageView imageView;
    ArrayList<String> receivedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        if (intent != null) {
            receivedArray = intent.getStringArrayListExtra("myArrayKey");
        }

        imageView = findViewById(R.id.imageView);
        String imageUrl = receivedArray.get(0);
        Picasso.with(this).load(imageUrl).into(imageView);

    }
}