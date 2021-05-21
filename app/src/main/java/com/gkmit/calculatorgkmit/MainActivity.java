package com.gkmit.calculatorgkmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn_add,btn_sub,btn_div,btn_ac,btn_mul,btn_eql;
    private TextView result;
    private float number1,number2;
    private boolean add,division,multiplication,subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_ac = (Button) findViewById(R.id.btn_ac);
        btn_eql = (Button) findViewById(R.id.btn_eql);

        result = (TextView) findViewById(R.id.result_view);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_eql.setOnClickListener(this);

    }

    //function to perform operation
    private void compute(float number1, float number2) {
        if(add){
            float answer = number1+number2;
            result.setText(answer+"");
            Toast.makeText(MainActivity.this, String.valueOf(answer), Toast.LENGTH_SHORT).show();

        }
        if(subtraction){
            float answer = number1-number2;
            result.setText(answer+"");
            Toast.makeText(MainActivity.this, String.valueOf(answer), Toast.LENGTH_SHORT).show();
        }
        if(multiplication){
            float answer = number1*number2;
            result.setText(answer+"");
            Toast.makeText(MainActivity.this, String.valueOf(answer), Toast.LENGTH_SHORT).show();
        }
        if(division){
            //will raise exception when number2 is equal to 0
            try{
                float answer = number1 / number2;
                result.setText(answer + "");
                Toast.makeText(MainActivity.this, String.valueOf(answer), Toast.LENGTH_SHORT).show();
            }
            catch(ArithmeticException error){
                Toast.makeText(this, "Division by zero " +error, Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                result.setText(result.getText().toString()+"0");
                break;
            case R.id.btn1:
                result.setText(result.getText().toString()+"1");
                break;
            case R.id.btn2:
                result.setText(result.getText().toString()+"2");
                break;
            case R.id.btn3:

                result.setText(result.getText().toString()+"3");
                break;
            case R.id.btn4:
                result.setText(result.getText().toString()+"4");
                break;
            case R.id.btn5:
                result.setText(result.getText().toString()+"5");
                break;
            case R.id.btn6:
                result.setText(result.getText().toString()+"6");
                break;
            case R.id.btn7:
                result.setText(result.getText().toString()+"7");
                break;
            case R.id.btn8:
                result.setText(result.getText().toString()+"8");
                break;
            case R.id.btn9:
                result.setText(result.getText().toString()+"9");
                break;
            case R.id.btn_ac:
                result.setText("");
                break;
            case R.id.btn_add:
                if(result==null){
                    result.setText("");
                }
                else {
                    number1 = Float.parseFloat(result.getText() + "");
                    add = true;
                    result.setText(null);
                }
                break;
            case R.id.btn_sub:
                if(result==null){
                    result.setText("");
                }
                else {
                    number1 = Float.parseFloat(result.getText() + "");
                    subtraction = true;
                    result.setText(null);
                }
                break;
            case R.id.btn_mul:
                if(result==null){
                    result.setText("");
                }
                else {
                    number1 = Float.parseFloat(result.getText() + "");
                    multiplication = true;
                    result.setText(null);
                }
                break;
            case R.id.btn_div:
                if(result==null){
                    result.setText("");
                }
                else {
                    number1 = Float.parseFloat(result.getText() + "");
                    division = true;
                    result.setText(null);
                }
                break;
            case R.id.btn_eql:
                number2 = Float.parseFloat(result.getText()+"");
                if(add){
                    compute(number1,number2);
                    add = false;
                }
                if(division){
                    compute(number1,number2);
                    division = false;
                }
                if(subtraction){
                    compute(number1,number2);
                    subtraction = false;
                }
                if(multiplication){
                    compute(number1,number2);
                    multiplication = false;
                }
                break;
            default:
                break;
        }
    }
}