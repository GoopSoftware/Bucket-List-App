package com.dzl.listapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        EditText titleInput = findViewById(R.id.edit_text_title);
        EditText descriptionInput = findViewById(R.id.edit_text_description);
        Button saveButton = findViewById(R.id.button_submit);

        saveButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String description = descriptionInput.getText().toString().trim();

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill the form out entirely.", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent resultIntent = new Intent();
            resultIntent.putExtra("title", title);
            resultIntent.putExtra("description", description);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

    }
}