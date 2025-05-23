package com.dzl.listapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = findViewById(R.id.image_view_bucket_list);
        image.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ItemsActivity.class);
            startActivity(intent);
        });

    }
}
