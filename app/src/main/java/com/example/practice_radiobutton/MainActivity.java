package com.example.practice_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.practice_radiobutton.exceptions.*;

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
        try {
            String value1_String = editText1.getText().toString();
            String value2_String = editText2.getText().toString();

            if(value1_String.equals("") || value2_String.equals("")){
                throw new NonNumberTyped();
            }

            int value1 = Integer.parseInt(value1_String);
            int value2 = Integer.parseInt(value2_String);
            int result;

            if (value1 != value2) {
                if (radioButtonAdd.isChecked()) {
                    result = value1 + value2;
                } else if (radioButtonSub.isChecked()) {
                    result = value1 - value2;
                } else if (radioButtonMul.isChecked()) {
                    result = value1 * value2;
                } else if (radioButtonDiv.isChecked()) {
                    result = value1 / value2;
                } else {
                    throw new NonOperationSelectedException();
                }

                textViewResult.setText(String.valueOf(result));
            } else {
                Toast.makeText(this, "Values mustn't be equals", Toast.LENGTH_SHORT).show();
            }
        } catch (NonOperationSelectedException e) {
            Toast.makeText(this, "Select an operation!", Toast.LENGTH_SHORT).show();
        } catch (NonNumberTyped nonNumberTyped) {
            Toast.makeText(this, "Type both numbers", Toast.LENGTH_SHORT).show();
        }
    }
}