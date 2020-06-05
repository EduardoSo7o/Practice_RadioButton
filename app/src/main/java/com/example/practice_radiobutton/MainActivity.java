package com.example.practice_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private RadioButton radioButtonAdd;
    private RadioButton radioButtonSub;
    private RadioButton radioButtonMul;
    private RadioButton radioButtonDiv;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.et_num1);
        editText2 = (EditText)findViewById(R.id.et_num2);
        radioButtonAdd = (RadioButton)findViewById(R.id.rb_addition);
        radioButtonSub = (RadioButton)findViewById(R.id.rb_subtraction);
        radioButtonMul = (RadioButton)findViewById(R.id.rb_multiplication);
        radioButtonDiv = (RadioButton)findViewById(R.id.rb_division);
        textViewResult = (TextView)findViewById(R.id.tv_result);
    }

    public void calculate(View view){
        int value1 = Integer.parseInt(editText1.getText().toString());
        int value2 = Integer.parseInt(editText2.getText().toString());
        int result;

        if(radioButtonAdd.isChecked()){
            result = value1 +value2;
        }else if(radioButtonSub.isChecked()){
            result = value1 - value2;
        }else if(radioButtonMul.isChecked()){
            result = value1 * value2;
        }else{
            result = value1 / value2;
        }

        textViewResult.setText(String.valueOf(result));
    }
}