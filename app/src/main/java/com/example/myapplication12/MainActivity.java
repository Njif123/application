package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn1;
    TextView tv1;
    String s, k;
    ArrayList<String> list;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add("привЕт");
        list.add("тОрты");
        list.add("кАрта");
        list.add("плОмба");
        list.add("договОр");
        list.add("звонИт");
        list.add("экспЕрт");
        list.add("бралАсь");
        list.add("недУг");
        btn1 = (Button) findViewById(R.id.btn1);
        tv1 = (TextView) findViewById(R.id.tv1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                srchArr(v);
            }
        });

    }



    public void srchArr(View view){
        et1= findViewById(R.id.et1);
        s=et1.getText().toString().toUpperCase();
        Log.d(TAG, s);
        for(int i = 0; i<list.size();i++){
            k=list.get(i).toUpperCase();
            Log.i(TAG, k);
            if(s.equals(k)){
                tv1.setText(list.get(i));
                break;
            }
            else{
                tv1.setText("Такого слова нет");
            }
        }

    }
}




