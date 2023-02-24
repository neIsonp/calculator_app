package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAc, btnDel, btnPlus, btnMinus, btnDivide, btnMulti, btnEquals, btnDot;

    private TextView textViewResult, textViewHistory;

    private String number = null;

    double firstNumber = 0, lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    String history, currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus =  findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);

        btnAc = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDEL);
        btnDot = findViewById(R.id.btnDot);
        btnEquals = findViewById(R.id.btnEquals);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+ currentResult + " + ");

                if(operator){
                    if (Objects.equals(status, "multiplication")) {
                        multiply();
                    }else if(Objects.equals(status, "division")){
                        divide();
                    }else if(Objects.equals(status, "subtraction")){
                        minus();
                    }else {
                        plus();
                    }

                    status = "sum";
                    operator = false;
                    number= null;
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+ currentResult + " - ");

                if(operator){
                    if (Objects.equals(status, "multiplication")) {
                        multiply();
                    }else if(Objects.equals(status, "division")){
                        divide();
                    }else if(Objects.equals(status, "sum")){
                        plus();
                    }else {
                        minus();
                    }

                    status = "subtraction";
                    operator = false;
                    number= null;
                }
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+ currentResult + " * ");

                if(operator){
                    if (Objects.equals(status, "sum")) {
                       plus();
                    }else if(Objects.equals(status, "division")){
                        divide();
                    }else if(Objects.equals(status, "subtraction")){
                        minus();
                    }else {
                        multiply();
                    }

                    status = "multiplication";
                    operator = false;
                    number= null;
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+ currentResult + " / ");

                if(operator){
                    if (Objects.equals(status, "multiplication")) {
                        multiply();
                    }else if(Objects.equals(status, "sum")){
                        plus();
                    }else if(Objects.equals(status, "subtraction")){
                        minus();
                    }else {
                        divide();
                    }

                    status = "division";
                    operator = false;
                    number= null;
                }
            }
        });



        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("0");
                firstNumber = 0;
                lastNumber = 0;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = number.substring(0, number.length() - 1);
                textViewResult.setText(number);

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operator){
                    if(Objects.equals(status, "sum")){
                        plus();
                    }else if(Objects.equals(status,"subtraction")){
                        minus();
                    }else if(Objects.equals(status, "multiplication")){
                        multiply();
                    }else if(Objects.equals(status, "division")){
                        divide();
                    }
                }else{
                    firstNumber = Double.parseDouble(textViewResult.getText().toString());

                }

                operator = false;

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number == null){
                    number = "0.";
                }else{
                    number += ".";
                }

                textViewResult.setText(number);
            }
        });
    }
    public void numberClick(String view){
        if(number == null){
            number = view;
        }
        else{
            number += view;
        }

        textViewResult.setText(number);
        operator = true;
    }

    public void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber += lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void minus(){

        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber -= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void multiply(){
        if(firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        }else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber *= lastNumber;
        }
        textViewResult.setText(myFormatter.format(firstNumber));
    }

    public void divide(){

        if(firstNumber == 0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber;
        }else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber /= lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));

    }
}