package com.mirrosha.pz43;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnToMain = findViewById(R.id.btnToMain);
        Button btnToThird = findViewById(R.id.btnToThird);

        btnToMain.setOnClickListener(v -> {
            finish();
        });

        btnToThird.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}
