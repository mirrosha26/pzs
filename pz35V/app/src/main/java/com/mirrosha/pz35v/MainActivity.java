package com.mirrosha.pz35v;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String TEXT_KEY = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Button saveButton = findViewById(R.id.saveButton);
        Button loadButton = findViewById(R.id.loadButton);

        String savedText = sharedPreferences.getString(TEXT_KEY, "");
        editText.setText(savedText);

        saveButton.setOnClickListener(v -> saveText());
        loadButton.setOnClickListener(v -> loadText());
    }

    private void saveText() {
        String text = editText.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT_KEY, text);
        editor.apply();
        Toast.makeText(this, "Текст сохранен", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        String savedText = sharedPreferences.getString(TEXT_KEY, "");
        editText.setText(savedText);
        Toast.makeText(this, "Текст загружен", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText();
    }
}