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
import java.util.List;
import java.util.Random;

public class Proverk extends AppCompatActivity {
    textUtility TextUtility;
    Integer b = 0;
    public int index;
    String ind;
    public int z;
    public ArrayList<String> randArr;

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
        randArr = new ArrayList<>();
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

        for (int i = 0; i<11; i++){
            randArr.add(test.get(random.nextInt(test.size())));
            i++;
        }
       
         ind = randArr.get(z);
         index = getIndex(ind);

        final String result = ind.toUpperCase();
        SpannableStringBuilder resultSpan = new SpannableStringBuilder(result);

        for (int i = 0; i < result.toCharArray().length; i++) {
            Character a = result.toCharArray()[i];
            if (glas.contains(a)) {
                SpannableString s = new SpannableString(a+"");
                s.setSpan(getClickableSpan(i),
                        0,
                        s.length(),
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                resultSpan.replace(i, i + 1, s);

            }
        }
//        for (int j = 0; j<result.length(); j++) {
//            Character ch = result.toCharArray()[j];
//            if (glas.contains(ch)) {
//                resultSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),
//                        j, j + 1,
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                resultSpan.setSpan(getClickableSpan(j), j, j+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
        word.setText(resultSpan);
        word.setMovementMethod(LinkMovementMethod.getInstance());

}
    private int getIndex(String s){
       int index = 0;
        s.toCharArray();
        for ( int i =0; i<s.toCharArray().length; i++){
            Character a = s.toCharArray()[i];
            if(a == Character.toUpperCase(s.toCharArray()[i])){
                index=i;
                break;
            }
            i++;
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
                if(c==index){
                Toast.makeText(Proverk.this, "правильно", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "кликнулось");
                }
                else{
                    Toast.makeText(Proverk.this, "неправильно", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "кликнулось");

                }
                synchronized (b) {

                }
                b = c;

            }
        };
    }
        @Override
        public void onBackPressed () {
            Intent intent = new Intent(Proverk.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

