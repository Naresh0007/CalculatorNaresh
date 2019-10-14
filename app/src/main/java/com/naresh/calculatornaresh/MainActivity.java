package com.naresh.calculatornaresh;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_p,
            button_s, button_m, button_d, button_e, button_dot, button_0, button_c,button_del;
    int count = 0;
    String doa;
    Num numbers = new Num();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    //hello
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_del=findViewById(R.id.erase);
        button_del.setOnClickListener(this);
        result = findViewById(R.id.output);
        result.setShowSoftInputOnFocus(false);
        button_0 = findViewById(R.id.button0);
        button_0.setOnClickListener(this);
        button_1 = findViewById(R.id.button1);
        button_1.setOnClickListener(this);
        button_2 = findViewById(R.id.button2);
        button_2.setOnClickListener(this);
        button_3 = findViewById(R.id.button3);
        button_3.setOnClickListener(this);
        button_4 = findViewById(R.id.button4);
        button_4.setOnClickListener(this);
        button_5 = findViewById(R.id.button5);
        button_5.setOnClickListener(this);
        button_6 = findViewById(R.id.button6);
        button_6.setOnClickListener(this);
        button_7 = findViewById(R.id.button7);
        button_7.setOnClickListener(this);
        button_8 = findViewById(R.id.button8);
        button_8.setOnClickListener(this);
        button_9 = findViewById(R.id.button9);
        button_9.setOnClickListener(this);
        button_p = findViewById(R.id.buttonaddition);
        button_p.setOnClickListener(this);
        button_s = findViewById(R.id.buttonsubtraction);
        button_s.setOnClickListener(this);
        button_m = findViewById(R.id.buttonmultiplication);
        button_m.setOnClickListener(this);
        button_d = findViewById(R.id.buttondivision);
        button_d.setOnClickListener(this);
        button_e = findViewById(R.id.buttonequal);
        button_e.setOnClickListener(this);
        button_dot = findViewById(R.id.buttondot);
        button_dot.setOnClickListener(this);
        button_c = findViewById(R.id.clear);
        button_c.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button0:
                result.append("0");
                break;
            case R.id.button1:
                result.append("1");
                break;
            case R.id.button2:
                result.append("2");
                break;
            case R.id.button3:
                result.append("3");
                break;
            case R.id.button4:
                result.append("4");
                break;
            case R.id.button5:
                result.append("5");
                break;
            case R.id.button6:
                result.append("6");
                break;
            case R.id.button7:
                result.append("7");
                break;
            case R.id.button8:
                result.append("8");
                break;
            case R.id.button9:
                result.append("9");
                break;
            case R.id.buttondot:
                if ((result.getText().toString()).contains(".")) {

                } else {
                    result.append(".");
                }
                break;
            case R.id.clear:
                try {
                    String NumberEntered = result.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 1);
                    String word = (NumberEntered);
                    result.setText(word);

                    return;

                } catch (Exception e) {

                    result.setError("please first enter value");
                }
                break;
            case R.id.buttonaddition:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "plus";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.buttonsubtraction:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "sub";}
                else{
                    result.setError("only two time");
                }
                break;
            case R.id.buttondivision:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "di";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.buttonmultiplication:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "mul";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.buttonequal:
                MathCal mathCal = new MathCal();
                count++;
                SetData(count);
                if (doa.equalsIgnoreCase("plus")) {
                    result.setText(mathCal.add(numbers));

                } else if (doa.equalsIgnoreCase("sub")) {
                    result.setText(mathCal.sub(numbers));

                } else if (doa.equalsIgnoreCase("di")) {
                    result.setText(mathCal.divide(numbers));

                } else if (doa.equalsIgnoreCase("mul")) {
                    result.setText(mathCal.mul(numbers));

                }

                break;
            case R.id.erase:
                result.setText("");
                count=0;
        }
    }

    public void SetData(int cou) {

        if (!result.getText().toString().isEmpty()) {
            if (cou == 1) {
                numbers.setFirstNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            } else if (cou == 2) {
                numbers.setSecondNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            } else {
                result.setError("only two time");
                return;
            }
        } else {
            result.setError("please enter the number first");
            count--;
            return;

        }

    }
}
