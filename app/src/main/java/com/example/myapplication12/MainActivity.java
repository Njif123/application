package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private long backPressedTime;
    private Toast backToast;
    EditText et1;
    Button btn2;
    TextView tv1;
    textUtility TextUtility;
    Intent startSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btn1 =  findViewById(R.id.btn1);
        tv1 = findViewById(R.id.tv1);
        // et1 = findViewById(R.id.et1);
        btn2 = findViewById(R.id.btn2);
        TextUtility = new textUtility();
        TextUtility.testFileFunc(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity = new Intent(MainActivity.this, proverk.class);
                startActivity(startSecondActivity);
                finish();
            }
        });
    }

    public void searchWord(View view) {
        String s = et1.getText().toString();
        String result = TextUtility.searchWord(s);
        // форматирование первого заглавновного символа в строке
        SpannableStringBuilder resultSpan = new SpannableStringBuilder(result);
        for (char ch : result.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                resultSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),
                        result.indexOf(ch), result.indexOf(ch) + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        tv1.setText(resultSpan);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_search);
        getMenuInflater().inflate(R.menu.toolbar, menu);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(backPressedTime + 2000 < System.currentTimeMillis()){
           // backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
             Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT).show();
            //backToast.show();
        }

        backPressedTime = System.currentTimeMillis();

    }
}




