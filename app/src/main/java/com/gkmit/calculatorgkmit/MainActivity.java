package com.gkmit.calculatorgkmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
                    buttonAdd, buttonSubtract, buttonDivide, buttonAllClear, buttonMultiply, buttonEqual, buttonDot;
    private TextView textViewResult, textViewInput;
    private float number1, number2;

    private boolean add, division, multiplication, subtraction, decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIds();
    }

    //function to perform operation
    private void compute(float number1, float number2) {
        float answer;
        if (add) {
            answer = number1 + number2;
            displayResult(answer);
            Toast.makeText(MainActivity.this,
                    "Addition result : " +answer,
                    Toast.LENGTH_SHORT).show();
            add=false;
        }
        else if (subtraction) {
            answer = number1 - number2;
            displayResult(answer);
            Toast.makeText(MainActivity.this,
                     "  Subtraction result : " +answer,
                    Toast.LENGTH_SHORT).show();
            subtraction=false;
        }
        else if (multiplication) {
            answer = number1 * number2;
            displayResult(answer);
            Toast.makeText(MainActivity.this,
                    "Multiplication result : " +answer,
                    Toast.LENGTH_SHORT).show();
            multiplication=false;
        }
        else if (division) {
            //will raise exception when number2 is equal to 0
            if (number2 != 0) {
                answer = number1/number2;
                displayResult(answer);
                Toast.makeText(MainActivity.this,
                        "Division result : " +answer,
                        Toast.LENGTH_SHORT).show();
                division=false;
            } else {
                Toast.makeText(this,
                        "Division by zero error!!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void displayResult(float result) {
        if (result == (int) result) {
            textViewResult.setText((int) result + "");
        } else {
            textViewResult.setText(result + "");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                textViewResult.setText(textViewResult.getText().toString() + "0");
                break;
            case R.id.button1:
                textViewResult.setText(textViewResult.getText().toString() + "1");
                break;
            case R.id.button2:
                textViewResult.setText(textViewResult.getText().toString() + "2");
                break;
            case R.id.button3:
                textViewResult.setText(textViewResult.getText().toString() + "3");
                break;
            case R.id.button4:
                textViewResult.setText(textViewResult.getText().toString() + "4");
                break;
            case R.id.button5:
                textViewResult.setText(textViewResult.getText().toString() + "5");
                break;
            case R.id.button6:
                textViewResult.setText(textViewResult.getText().toString() + "6");
                break;
            case R.id.button7:
                textViewResult.setText(textViewResult.getText().toString() + "7");
                break;
            case R.id.button8:
                textViewResult.setText(textViewResult.getText().toString() + "8");
                break;
            case R.id.button9:
                textViewResult.setText(textViewResult.getText().toString() + "9");
                break;
            case R.id.button_dot:
                textViewResult.setText(textViewResult.getText().toString() + ".");
                decimal=true;
                break;
            case R.id.button_ac:
                textViewResult.setText("");
                textViewInput.setText("");
                enableButtons();
                break;

            case R.id.button_add:
                number1 = getNumberOne();
                add = true;
                textViewInput.setText(number1+ " + ");
                textViewResult.setText(null);
                disableButtons();
                break;

            case R.id.button_subtract:
                number1 = getNumberOne();
                subtraction = true;
                textViewInput.setText(number1+ " - ");
                textViewResult.setText(null);
                disableButtons();
                break;

            case R.id.button_multiply:
                number1 = getNumberOne();
                multiplication = true;
                textViewInput.setText(number1+ " × ");
                textViewResult.setText(null);
                disableButtons();
                break;

            case R.id.button_divide:
                number1 = getNumberOne();
                division = true;
                textViewInput.setText(number1+ " ÷ ");
                textViewResult.setText(null);
                disableButtons();
                break;

            case R.id.button_equal:
                if (add || division || multiplication || subtraction) {
                    if (textViewResult.getText() != "") {
                        number2 = (decimal) ? Float.parseFloat(textViewResult.getText().toString()) :
                                                Integer.parseInt(textViewResult.getText() + "");
                        textViewInput.setText(textViewInput.getText().toString()+ number2);
                        compute(number1, number2);
                        enableButtons();
                        decimal = false;
                    } else {
                        Toast.makeText(this,
                                "Please enter the second number",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }

    private float getNumberOne() {
         number2 = (decimal) ? Float.parseFloat(textViewResult.getText().toString()) :
                Integer.parseInt(textViewResult.getText() + "");
        return number2;
    }

    private void enableButtons() {
        buttonAdd.setClickable(true);
        buttonSubtract.setClickable(true);
        buttonDivide.setClickable(true);
        buttonMultiply.setClickable(true);
    }

    private void disableButtons() {
        buttonAdd.setClickable(false);
        buttonSubtract.setClickable(false);
        buttonDivide.setClickable(false);
        buttonMultiply.setClickable(false);
    }

    private void mapIds() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubtract = findViewById(R.id.button_subtract);
        buttonDivide = findViewById(R.id.button_divide);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonAllClear = findViewById(R.id.button_ac);
        buttonEqual = findViewById(R.id.button_equal);
        buttonDot = findViewById(R.id.button_dot);

        textViewResult = findViewById(R.id.textView_result);
        textViewInput = findViewById(R.id.textView_input);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAllClear.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
    }

}