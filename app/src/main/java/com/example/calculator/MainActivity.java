package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
           btnAdd, btnSub, btnMul, btnDiv, btnEq, btnSw, btnDot,
           btnCE, btnC, btnBS;
    TextView textViewLog, textViewDis;
    Double var1, var2, ans;
    char sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btnAdd = findViewById(R.id.button_add);
        btnSub = findViewById(R.id.button_sub);
        btnMul = findViewById(R.id.button_mul);
        btnDiv = findViewById(R.id.button_div);
        btnEq = findViewById(R.id.button_eq);
        btnSw = findViewById(R.id.button_sw);
        btnDot = findViewById(R.id.button_dot);
        btnCE = findViewById(R.id.button_ce);
        btnC = findViewById(R.id.button_c);
        btnBS = findViewById(R.id.button_bs);

        textViewLog = findViewById(R.id.textView_log);
        textViewDis = findViewById(R.id.textView_display);

        btn0.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "0");
        });

        btn1.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "1");
            else textViewDis.setText("1");
        });

        btn2.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "2");
            else textViewDis.setText("2");
        });

        btn3.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "3");
            else textViewDis.setText("3");
        });

        btn4.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "4");
            else textViewDis.setText("4");
        });

        btn5.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "5");
            else textViewDis.setText("5");
        });

        btn6.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "6");
            else textViewDis.setText("6");
        });

        btn7.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "7");
            else textViewDis.setText("7");
        });

        btn8.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "8");
            else textViewDis.setText("8");
        });

        btn9.setOnClickListener((v)->{
            if(!textViewDis.getText().equals("0"))
                textViewDis.setText(textViewDis.getText() + "9");
            else textViewDis.setText("9");
        });

        btnAdd.setOnClickListener((v)->{
            sign = '+';
            setVar1();
            textViewDis.setText("0");
        });

        btnSub.setOnClickListener((v)->{
            sign = '-';
            setVar1();
            textViewDis.setText("0");
        });

        btnMul.setOnClickListener((v)->{
            sign = '*';
            setVar1();
            textViewDis.setText("0");
        });

        btnDiv.setOnClickListener((v)->{
            sign = '/';
            setVar1();
            textViewDis.setText("0");
        });

        btnDot.setOnClickListener((v)->{
            textViewDis.append(".");
        });

        btnSw.setOnClickListener((v)->{
            Double d = Double.parseDouble(textViewDis.getText().toString());
            d = -d;
            textViewDis.setText(formatDouble(d));
        });

        btnCE.setOnClickListener((v)->{
            textViewDis.setText("0");
        });

        btnC.setOnClickListener((v)->{
            textViewLog.setText("");
            textViewDis.setText("0");
        });

        btnBS.setOnClickListener((v)->{
            String s = textViewDis.getText().toString();
            if(!s.equals(""))
                s = s.substring(0, s.length()-1);
            if(s.equals(""))
                s = "0";
            textViewDis.setText(s);
        });

        btnEq.setOnClickListener((v)->{

            try {
                setVar2();
                if (sign == '+') ans = var1 + var2;
                else if (sign == '-') ans = var1 - var2;
                else if (sign == '*') ans = var1 * var2;
                else if (sign == '/') ans = var1 / var2;
                textViewDis.setText(formatDouble(ans));
            }
            catch(Exception e){
                textViewLog.setText("");
                textViewDis.setText("ERROR");
            }

        });

    }

    public void setVar1(){
        var1 = Double.parseDouble(textViewDis.getText().toString());
        textViewLog.setText(textViewDis.getText() + String.valueOf(sign));
    }

    public void setVar2(){
        var2 = Double.parseDouble(textViewDis.getText().toString());
        textViewLog.setText(formatDouble(var1) + String.valueOf(sign) + formatDouble(var2) + "=");
    }

    public String formatDouble(Double d){
        String s = d.toString();
        while(s.charAt(s.length()-1) == '0')
            s = s.substring(0, s.length()-1);
        if(s.charAt(s.length()-1) == '.')
            s = s.substring(0, s.length()-1);
        return s;
    }

}