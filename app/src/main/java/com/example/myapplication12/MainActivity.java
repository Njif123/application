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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity  {
    private long backPressedTime;
    SearchView sv;
    private Toast backToast;
    EditText et1;
    Button btn2;
    Button btn1;
    TextView tv1;
    textUtility TextUtility;
    searchView_listenner svl;
    ListView lv;
    Intent startSecondActivity;
    //ArrayAdapter adapter;
    ArrayAdapter testAD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // btn1 =  findViewById(R.id.btn1
        // = findViewById(R.id.et1);
        sv = findViewById(R.id.searchView);
        btn2 = findViewById(R.id.btn2);
        lv = findViewById(R.id.listView);
        TextUtility = new textUtility();
       // svl = new searchView_listenner(adapter);

       // adapter = TextUtility.arrayAdapter(getApplicationContext());

        TextUtility.testFileFunc(this);

        ArrayList<String> test ;

        test = TextUtility.myArray;

        testAD = new MyArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, test);

        lv.setAdapter(testAD);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                testAD.getFilter().filter(newText);
                return false;
            }
        });

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                searchWord(v);
//            }
//        });

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


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView sw = (SearchView) menuItem.getActionView();
//        (sw).setOnQueryTextListener(new searchView_listenner(adapter));
//
//        return true;
//    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        boolean flag = true;
        Toast toast = Toast.makeText(getApplicationContext(), "Нажми ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
        if(backPressedTime + 2000 < System.currentTimeMillis()){
            toast.show();
            backPressedTime = System.currentTimeMillis();
        }
        else{

            toast.cancel();
            super.onBackPressed();


            // toast.makeText( "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT).show();
        }

    }
}




