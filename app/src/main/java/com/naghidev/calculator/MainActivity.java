package com.naghidev.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // access Number fields
        final EditText numberOne = findViewById(R.id.number1);
        final EditText numberTwo = findViewById(R.id.number2);

        // access RadioGroup
        final RadioGroup operators = findViewById(R.id.operators);

        // access RadioButtons
        final RadioButton add = findViewById(R.id.add);
        final RadioButton subtract = findViewById(R.id.subtract);
        final RadioButton multiply = findViewById(R.id.multiply);
        // final RadioButton divide = findViewById(R.id.divide);

        // access equal Button
        Button equals = findViewById(R.id.equals);

        // access result TextView
        final TextView result = findViewById(R.id.result);

        // add eventListener for equals Button
        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // debug
                System.out.println("Equals Button is clicked.");

                // get user input from Number fields
                Double firstNumberValue = null;
                Double secondNumberValue = null;

                Boolean firstNumEmpty = numberOne.getText().equals("");
                Boolean secondNumEmpty = numberTwo.getText().equals("");

                if(!firstNumEmpty || !secondNumEmpty) {
                    firstNumberValue = Double.parseDouble(numberOne.getText().toString());
                    secondNumberValue = Double.parseDouble(numberTwo.getText().toString());
                } else {
                    if(firstNumEmpty){
                        firstNumberValue = null;
                    } else {
                        secondNumberValue = null;
                    }
                }


                // get user entered operator
                int operatorButtonId = operators.getCheckedRadioButtonId();

                // declare variable to store operation answer
                Double answer;

            if(firstNumberValue != null && secondNumberValue != null) {
                // evaluate answer
                if (operatorButtonId == add.getId()) {
                    answer = firstNumberValue + secondNumberValue;
                } else if (operatorButtonId == subtract.getId()) {
                    answer = firstNumberValue - secondNumberValue;
                } else if (operatorButtonId == multiply.getId()) {
                    answer = firstNumberValue * secondNumberValue;
                } else {
                    if (secondNumberValue != 0) {
                        answer = firstNumberValue / secondNumberValue;
                    } else {
                        answer = null;
                    }
                }

                // present result to user
                if(answer != null){
                    result.setText(answer.toString());
                } else {
                    result.setText("Zero division error");
                }

            } else {
                result.setText("Number filed cannot be empty");
            }


            }

        });

    }
}
