package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class proverk extends AppCompatActivity {
    textUtility TextUtility;
    final Random random = new Random();
    TextView word = findViewById(R.id.word);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverk);
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(proverk.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextUtility = new textUtility();
        ArrayList<String> test;
        test = TextUtility.myArray;

        List<Character> glas = new ArrayList<>();
        glas.add('ё');
        glas.add('у');
        glas.add('е');
        glas.add('ы');
        glas.add('а');
        glas.add('о');
        glas.add('э');
        glas.add('я');
        glas.add('и');
        glas.add('ю');

        String result = test.get(random.nextInt(test.size() + 1));
        SpannableStringBuilder resultSpan = new SpannableStringBuilder(result);
        for (int j = 0; j < result.length(); j++) {
            Character ch = result.toCharArray()[j];
            if (glas.contains(ch)) {
                resultSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),
                        j, j + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }
        word.setText(resultSpan);
    }
        @Override
        public void onBackPressed () {
            Intent intent = new Intent(proverk.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

