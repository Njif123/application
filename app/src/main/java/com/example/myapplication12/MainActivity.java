package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication12.pojo.Example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity  {
    TextView response1;
    ImageButton cancelBtn;
    WikiApi wikiApi;
    private Retrofit mRetrofit;
    Example ex;
    NetworkService networkService;
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
    ArrayAdapter testAD;
    String extr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = findViewById(R.id.searchView);
        btn2 = findViewById(R.id.btn2);
        lv = findViewById(R.id.listView);
        cancelBtn = findViewById(R.id.cancelBtn);
        TextUtility = new textUtility();
        networkService = NetworkService.getInstance();
        ex = new Example();
        wikiApi = networkService.getWikiApi();
        response1 = findViewById(R.id.responseRetr);


        TextUtility.testFileFunc(this);

        final ArrayList<String> test ;

        test = TextUtility.myArray;

        testAD = new MyArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, test);

        lv.setAdapter(testAD);
        //Кнопка, убирающая информацию о слове
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response1.setText("Здесь будет выводиться информация о слове");
            }
        });

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
        //Обработка клика по слову
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = lv.getItemAtPosition(position).toString().toLowerCase();


                try {
                    wikiApi.getSummary(item).enqueue(new Callback<Example>() {
                        @Override
                        public void onResponse(retrofit2.Call<Example> call, Response<Example> response) {
                            try{
                            extr = response.body().getExtract();
                            response1.setText(extr);}
                            catch(NullPointerException e) {
                                Toast.makeText(getApplicationContext(), "К сожалению, информация недоступна", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(retrofit2.Call<Example> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Проблемы с соединением", Toast.LENGTH_SHORT).show();
                            Log.d("LOG", t.toString());
                        }
                    });
                }
                catch(Exception e) {
                }
                }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity();
            }
        });
    }



    //двойной клик по кнопке назад для выхода из приложения
    @Override
    public void onBackPressed() {
        boolean flag = true;
        Toast toast = Toast.makeText(getApplicationContext(), "Нажми ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
        if(backPressedTime + 2000 < System.currentTimeMillis()){
            toast.show();
            backPressedTime = System.currentTimeMillis();
        }
        else{

            toast.cancel();
            super.onBackPressed();

        }

    }
    public void startActivity(){
        Intent startSecondActivity = new Intent(this, Proverk.class);
        startActivity(startSecondActivity);
        finish();
    }
}




