package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myArray;
    EditText et1;
    Button btn1;
    TextView tv1;
    // не нужно так именовать переменные
    String s, k;
    TextUtility textUtility;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // не обязательно приводить к типу, оно все равно выпадет с ошибкой, если не тот объект поймаем
        btn1 = (Button) findViewById(R.id.btn1);
        tv1 = (TextView) findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        // вот тут вызываем какие-то штуки для подготовки, но не долго
        textUtility = new TextUtility();
        // textUtility.testFileFunc();
        textUtility.simpleArray();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchWord(v);
            }
        });

    }

    // переименуй функцию
    // создал класс-хелпер в который сгрузил все функции связанные с текстом
    // эта функция занимается отображением слова
    // TODO: заменить на searchView все это
        public void searchWord(View view){
            String s = et1.getText().toString();
            String result = textUtility.searchWord(s);
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



