package com.example.again;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        Intent intent = this.getIntent();
        String errorCode = intent.getStringExtra("errorCode");
        TextView textView = findViewById(R.id.errorCode);
        textView.setText(errorCode);
    }
}
