package com.example.again;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonuc = findViewById(R.id.sayiGoster);


    }

    public void clear(View view){
        number = null;
        sonuc.setText(String.valueOf(0));
    }

    int firstNumber = 0;
    int lastNumber = 0;
    public void topla(){

        lastNumber=Integer.parseInt(sonuc.getText().toString());
        firstNumber=firstNumber+lastNumber;
        sonuc.setText(""+firstNumber);

    }


    public void btnTopla(View view){

        topla();
        number=null;

    }

    String number = null;

    public void numbersClick(View view){


    if(number==null){

        number=view.getTag().toString();
    }else{

        number=number+view.getTag().toString();

    }

    sonuc.setText(number);

    }


}