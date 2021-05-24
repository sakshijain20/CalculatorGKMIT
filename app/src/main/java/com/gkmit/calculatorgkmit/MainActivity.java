package com.gkmit.calculatorgkmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
            buttonAdd, buttonSubtract, buttonDivide, buttonAllClear, buttonMultiply, buttonEqual;
    private TextView textViewResult, textViewInput;
    private int number1, number2;
    private boolean add, division, multiplication, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIds();
    }

    //function to perform operation
    private void compute(int number1, int number2) {
        int answer;
        if (add) {
            answer = number1 + number2;
            textViewResult.setText(answer + "");
            Toast.makeText(MainActivity.this,
                    String.valueOf(number1+ "+" +number2 + "=" +answer),
                    Toast.LENGTH_SHORT).show();
            add=false;
        }
        else if (subtraction) {
            answer = number1 - number2;
            textViewResult.setText(answer + "");
            Toast.makeText(MainActivity.this,
                    String.valueOf(number1+ "-" +number2 + "=" +answer),
                    Toast.LENGTH_SHORT).show();
            subtraction=false;
        }
        else if (multiplication) {
            answer = number1 * number2;
            textViewResult.setText(answer + "");
            Toast.makeText(MainActivity.this,
                    String.valueOf(number1+ "×" +number2 + "=" +answer),
                    Toast.LENGTH_SHORT).show();
            multiplication=false;
        }
        else if (division) {
            //will raise exception when number2 is equal to 0
            if (number2 != 0) {
                float num1 = Float.parseFloat(String.valueOf(number1));
                float num2 = Float.parseFloat(String.valueOf(number2));
                textViewResult.setText(num1/num2 + "");
                Toast.makeText(MainActivity.this,
                        String.valueOf(num1+ "÷" +num2 + "=" +num1/num2),
                        Toast.LENGTH_SHORT).show();
                division=false;
            } else {
                Toast.makeText(this,
                        "Division by zero error!!",
                        Toast.LENGTH_SHORT).show();
            }
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
            case R.id.button_ac:
                textViewResult.setText("");
                textViewInput.setText("");
                break;
            case R.id.button_add:
                if (textViewResult == null) {
                    textViewResult.setText("");
                } else {
                    number1 = Integer.parseInt(textViewResult.getText() + "");
                    add = true;
                    textViewInput.setText(number1+ " + ");
                    textViewResult.setText(null);
                    buttonAdd.setClickable(false);
                    buttonSubtract.setClickable(false);
                    buttonDivide.setClickable(false);
                    buttonMultiply.setClickable(false);
                }
                break;

            case R.id.button_subtract:
                number1 = Integer.parseInt(textViewResult.getText() + "");
                subtraction = true;
                textViewInput.setText(number1+ " - ");
                textViewResult.setText(null);
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonDivide.setClickable(false);
                buttonMultiply.setClickable(false);
                break;

            case R.id.button_multiply:
                number1 = Integer.parseInt(textViewResult.getText() + "");
                multiplication = true;
                textViewInput.setText(number1+ " × ");
                textViewResult.setText(null);
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonDivide.setClickable(false);
                buttonMultiply.setClickable(false);
                break;

            case R.id.button_divide:
                number1 = Integer.parseInt(textViewResult.getText() + "");
                division = true;
                textViewInput.setText(number1+ " ÷ ");
                textViewResult.setText(null);
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonDivide.setClickable(false);
                buttonMultiply.setClickable(false);
                break;

            case R.id.button_equal:
                if (add || division || multiplication || subtraction) {
                    if (textViewResult.getText() != "") {
                        number2 = Integer.parseInt(textViewResult.getText() + "");
                        textViewInput.setText(textViewInput.getText().toString()+ number2);
                        compute(number1, number2);
                        buttonAdd.setClickable(true);
                        buttonSubtract.setClickable(true);
                        buttonDivide.setClickable(true);
                        buttonMultiply.setClickable(true);
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

    private void mapIds() {
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSubtract = (Button) findViewById(R.id.button_subtract);
        buttonDivide = (Button) findViewById(R.id.button_divide);
        buttonMultiply = (Button) findViewById(R.id.button_multiply);
        buttonAllClear = (Button) findViewById(R.id.button_ac);
        buttonEqual = (Button) findViewById(R.id.button_equal);

        textViewResult = (TextView) findViewById(R.id.textView_result);
        textViewInput = (TextView) findViewById(R.id.textView_input);

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
    }
}