package com.gkmit.calculatorgkmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn_add,btn_sub,btn_div,btn_ac,btn_mul,btn_eql;
    TextView result;
    String str;
    float num1,num2;
    boolean add,division,multiplication,subtraction;


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
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_div = findViewById(R.id.btn_div);
        btn_mul = findViewById(R.id.btn_mul);
        btn_ac = findViewById(R.id.btn_ac);
        btn_eql = findViewById(R.id.btn_eql);

        result = (TextView) findViewById(R.id.result_view);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText(str+"9");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = result.getText().toString();
                result.setText("");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result==null){
                    result.setText("");
                }
                else {
                    num1 = Float.parseFloat(result.getText() + "");
                    add = true;
                    result.setText(null);
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result==null){
                    result.setText("");
                }
                else{
                    num1 = Float.parseFloat(result.getText()+"");
                    subtraction = true;
                    result.setText(null);
                }
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result==null){
                    result.setText("");
                }
                else{
                    num1 = Float.parseFloat(result.getText()+"");
                    multiplication = true;
                    result.setText(null);
                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result==null){
                    result.setText("");
                }
                else{
                    num1 = Float.parseFloat(result.getText()+"");
                    division = true;
                    result.setText(null);
                }
            }
        });

        btn_eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Float.parseFloat(result.getText()+"");
                if(add){
                    result.setText(num1+num2+"");
                    float res = num1+num2;
                    Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_SHORT).show();
                    add = false;
                }
                if(division){
                    result.setText(num1/num2+"");
                    float res = num1/num2;
                    Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_SHORT).show();
                    division = false;
                }
                if(subtraction){
                    result.setText(num1-num2+"");
                    float res = num1-num2;
                    Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_SHORT).show();
                    subtraction = false;
                }
                if(multiplication){
                    result.setText(num1*num2+"");
                    float res = num1*num2;
                    Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_SHORT).show();
                    multiplication = false;
                }
            }
        });


    }
}