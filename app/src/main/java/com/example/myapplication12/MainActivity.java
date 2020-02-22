package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myArray;
    EditText et1;
    Button btn1;
    TextView tv1;
    String s, k;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        tv1 = (TextView) findViewById(R.id.tv1);
        Arr();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchWord(v);
            }
        });

    }
    public void Arr(){
        myArray = new ArrayList<>();
        try{
            File words = new File("/lop1v3.txt");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(words), "UTF8"));

                String str;

                while ((str = in.readLine()) != null) {
                    myArray.add(str);
                }

                in.close();
            }
            catch (UnsupportedEncodingException e)
            {
                Log.e("myapp","Oshiba");
            }
            catch (IOException e)
            {
                Log.e("myapp", "2");
            }
            catch (Exception e)
            {
                Log.e("myapp","3");
            }
        }
        public void searchWord(View view){
        String s = et1.getText().toString();
        for(int i = 0; i<myArray.size(); i++){
            if(s.toUpperCase()==(String)(myArray.get(i)).toUpperCase()){
                tv1.setText((String)(myArray.get(i)));
                break;
            }
            else{
                tv1.setText("Такого слова нет");
            }
        }
        }
        }



