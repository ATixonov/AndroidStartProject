package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ToInfActivity extends AppCompatActivity {


    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_inf);

       tv1 = (TextView) findViewById(R.id.tv1);
       String str = getIntent().getStringExtra("et");
       tv1.setText(str);
    }
}