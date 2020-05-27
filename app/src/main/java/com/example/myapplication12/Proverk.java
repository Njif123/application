package com.example.myapplication12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Proverk extends AppCompatActivity {
    public textUtility TextUtility;
    // не помню уже зачем это поле
    Integer b = 0;
    public int index;
    String ind;
    public int z = 0;
    public String[] randArr;
    public TextView word;
    public  TextView task;
    public int sch = 0;
    public ArrayList<String> test;
    public Random random= new Random();
    public ArrayList<Character> glas;
    public Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverk);

        tryAgain = findViewById(R.id.tryAgain);
        tryAgain.setVisibility(View.INVISIBLE);
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proverk.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextUtility = new textUtility();
        TextUtility.testFileFunc(this);

        test = TextUtility.myArray;
        randArr = new String[10];
        randArray();
        word = findViewById(R.id.word);
        task = findViewById(R.id.task);
        glas = new ArrayList<>();
        for (Character c: "ЁУЕЫАОЭЯИЮ".toCharArray()) {
            glas.add(c);
        }


        ind = randArr[z];
        word.setText(getString(ind));
        word.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // меотод возврщащий по требоавнию спан - строку
    private SpannableStringBuilder getString(String str) {
        index = getIndex(str);
        str = str.toUpperCase();
        SpannableStringBuilder resultSpan = new SpannableStringBuilder(str);
        for (int i = 0; i < str.toCharArray().length; i++) {
            Character a = str.toCharArray()[i];
            if (glas.contains(a)) {
                SpannableString s = new SpannableString(a + "");
                s.setSpan(getClickableSpan(i),
                        0,
                        s.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                resultSpan.replace(i, i + 1, s);

            }
        }
        return resultSpan;
    }


    //метод создающий рандомный массив слов
    public void randArray(){
        for (int i = 0; i < 10; i++) {
            TextUtility = new textUtility();
            TextUtility.testFileFunc(this);
            test = TextUtility.myArray;

            randArr[i] = test.get(random.nextInt(test.size()));
        }
    }
    //метод вызывающий следующее слово из массива
    public void nextWord() {
        try{
            z++;
            ind = randArr[z];
            word.setText(getString(ind));
        }
        catch (ArrayIndexOutOfBoundsException e){
            task.setText("Конец");
            word.setText("Неверных попыток: "+sch);
            tryAgain.findViewById(R.id.tryAgain);
            tryAgain.setVisibility(View.VISIBLE);
            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Proverk.this, Proverk.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    // поменял реализацию метода
    private int getIndex(String s) {
        int g = 0;
        for (Character a : s.toCharArray()) {
            if(glas.contains(Character.toUpperCase(a))) {
                g++;
            }
        }
        index = 0;
        for (Character a : s.toCharArray()) {
            if(g>1){
                if (Character.isUpperCase(a)) {
                 index = s.indexOf(a);
                 break;
            }
            }
            else {
                if(glas.contains(Character.toUpperCase(a))) {
                    index = s.indexOf(a);
                    break;
                }
            }
        }
        return index;
    }

    private ClickableSpan getClickableSpan(final int i) {
        return new ClickableSpan() {
            int c;

            {
                c = i;
            }

            @Override
            public void onClick(@NonNull View widget) {
                if (c == index) {
                    Toast.makeText(Proverk.this, "правильно", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "кликнулось");
                    nextWord();
                } else {
                    Toast.makeText(Proverk.this, "неправильно", Toast.LENGTH_SHORT).show();
                    sch++;
                    Log.d("TAG", "кликнулось");

                }
                synchronized (b) {
                    b = c;
                }


            }
        };
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Proverk.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}