package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

public class Calculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculateAnswer();
                } catch (Exception e) {
//                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                    finish(); // прерывание
                      e.printStackTrace();
                      dropFields(); //восстановление
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(Calculator.this, MainActivity.class);
                //startActivity(i);
            }
        });
    }
    private void dropFields(){
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);
        TextView answer = (TextView) findViewById(R.id.result);

        answer.setText("Now we have problems, try later");
    }

    private void calculateAnswer() throws ArithmeticException, InputMismatchException {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);
        TextView answer = (TextView) findViewById(R.id.result);

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());
        float solution = 0;
        if (add.isChecked()) {
            solution = numone + numtwo;
        }
        if (subtract.isChecked()) {
            solution = numone - numtwo;
        }
        if (multiply.isChecked()) {
            solution = numone * numtwo;
        }
        if (divide.isChecked()) {
            if (numtwo == 0) {
                Toast.makeText(this, "Number two cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }
        answer.setText("The result is " + solution);

        switch ((int) Math.random() * 2) {
            case 0:throw new ArithmeticException("I'm generated arithmetic exception");
            case 1:throw new InputMismatchException("I'm generated io exception");
        }
    }
}