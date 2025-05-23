package com.dzl.listapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        TextView titleTextView = findViewById(R.id.text_detail_title);
        titleTextView.setText(title != null ? title : "No data received");

        TextView descriptionTextView = findViewById(R.id.text_detail_description);
        descriptionTextView.setText(description != null ? description : "No data received");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            int position = getIntent().getIntExtra("position", -1);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("position", position);
            setResult(RESULT_OK, resultIntent);
            finish();
        });



    }
}
