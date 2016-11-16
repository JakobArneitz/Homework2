package com.example.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView resultView;

    public final static String EXTRA_MESSAGE="com.example.hw2.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editTextNumber1);
        editText2 = (EditText) findViewById(R.id.editTextNumber2);
        resultView = (TextView) findViewById(R.id.textViewResult);


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.textViewResult);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void calcNyq(View view) {
        String num1String = editText1.getText().toString();
        String num2String = editText2.getText().toString();

        double num1=0;
        double num2=0;

        try{num1=Double.parseDouble(num1String);
            num2=Double.parseDouble(num2String);
            double result = 2*num1*Math.log(num2);
            resultView.setText(String.valueOf(result));
        } catch (Exception e) {
            resultView.setText("WRONG INPUT!!!!!");
            e.printStackTrace();
        }


    }

    public void showAbout(View view) {
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        String message = resultView.getText().toString();
        intent.putExtra("myMessage", message);

        startActivity(intent);
    }

}
