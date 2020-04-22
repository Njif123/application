package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Proverk extends AppCompatActivity {
    textUtility TextUtility;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverk);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proverk.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final Random random = new Random();
        TextUtility = new textUtility();
        TextUtility.testFileFunc(this);
        ArrayList<String> test;
        test = TextUtility.myArray;
        TextView word = findViewById(R.id.word);
        List<Character> glas = new ArrayList<>();
        glas.add('Ё');
        glas.add('У');
        glas.add('Е');
        glas.add('Ы');
        glas.add('А');
        glas.add('О');
        glas.add('Э');
        glas.add('Я');
        glas.add('И');
        glas.add('Ю');

        String result = test.get(random.nextInt(test.size() + 1)).toUpperCase();
        SpannableString resultSpan = new SpannableString(result);
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View textView) {
                Toast toast = Toast.makeText(getApplicationContext(), "Нажми ещё раз", Toast.LENGTH_SHORT);
                toast.show();
            }

        };
        for (int j = 0; j<result.length(); j++) {
            Character ch = result.toCharArray()[j];
            if (glas.contains(ch)) {
                resultSpan.setSpan(clickableSpan, j, j+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                resultSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),
                        j, j + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        word.setText(resultSpan);
    }
        @Override
        public void onBackPressed () {
            Intent intent = new Intent(Proverk.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

