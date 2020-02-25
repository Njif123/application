package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn1, btn2;
    TextView tv1;
    textUtility TextUtility;
    Intent startSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =  findViewById(R.id.btn1);
        tv1 =  findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        btn2 = findViewById(R.id.btn2);
        TextUtility = new textUtility();
        TextUtility.testFileFunc(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchWord(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startSecondActivity = new Intent(MainActivity.this, proverk.class);
             startActivity(startSecondActivity);
            }
        });
    }

        public void searchWord(View view){
        String s = et1.getText().toString();
        String result = TextUtility.searchWord(s);
            // форматирование первого заглавновного символа в строке
            SpannableStringBuilder resultSpan = new SpannableStringBuilder(result);
            for (char ch: result.toCharArray()){
                if (Character.isUpperCase(ch)){
                    resultSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),
                            result.indexOf(ch), result.indexOf(ch)+1,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            tv1.setText(resultSpan);
        }
        }




